package aiss.githubminer.service;

import aiss.gitminer.model.Project;
import aiss.githubminer.model.ProjectGHM;
import aiss.githubminer.transformer.ProjectTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProjectTransformer transformer;

    /**
     * Función para optener un proyecto en formato GitHubMiner
    */

    public ProjectGHM getProject(String owner, String repo) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo;
        return restTemplate.getForObject(url, ProjectGHM.class);
    }

    /**
     * Función para optener un proyecto en formato GitMiner
     */

    public Project getMapProject(String owner, String repo, Integer sinceCommits, Integer sinceIssues, Integer maxPages) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo;
        ProjectGHM projectGHM = restTemplate.getForObject(url, ProjectGHM.class);

        return transformer.transform(projectGHM, sinceCommits, sinceIssues, maxPages);
    }


}
