package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.BitBucketProject;
import aiss.gitminer.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static aiss.bitbucketminer.etl.ProjectTransformer.transformProject;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    public ProjectService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Project getProject(String username, String repoSlug, int nCommits, int nIssues, int maxPages) {
        try {
            String url = String.format("https://api.bitbucket.org/2.0/repositories/%s/%s", username, repoSlug);
            BitBucketProject project = restTemplate.getForObject(url, BitBucketProject.class);
            assert project != null;
            return transformProject(project, nCommits, nIssues, maxPages);
        } catch (Exception e) {
            System.err.println("Failed to obtain the project: " + e.getMessage());
            return null;
        }
    }

}



