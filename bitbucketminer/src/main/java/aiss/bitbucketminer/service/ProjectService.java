package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.BitBucketProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import aiss.gitminer.model.Project;

import static aiss.bitbucketminer.etl.ProjectTransformer.transformProject;

@Service
public class ProjectService {

    private final RestTemplate restTemplate;

    @Autowired
    public ProjectService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Project getProject(String username, String repoSlug, int nCommits, int nIssues, int maxPages) {
        String url = String.format("https://api.bitbucket.org/2.0/repositories/%s/%s", username, repoSlug);
        BitBucketProject project = restTemplate.getForObject(url, BitBucketProject.class);
        assert project != null;
        return transformProject(project, nCommits, nIssues, maxPages);
    }

}



