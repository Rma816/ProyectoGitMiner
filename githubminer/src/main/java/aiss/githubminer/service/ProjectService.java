package aiss.githubminer.service;

import aiss.githubminer.model.ProjectGHM;
import aiss.githubminer.transformer.ProjectTransformer;
import aiss.gitminer.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        try {
            String url = "https://api.github.com/repos/" + owner + "/" + repo;
            return restTemplate.getForObject(url, ProjectGHM.class);
        } catch (Exception e) {
            System.err.println("Failed to obtain the project: " + e.getMessage());
            return null;
        }
    }

    /**
     * Función para optener un proyecto en formato GitMiner
     */

    public Project getMapProject(String owner, String repo, Integer sinceCommits, Integer sinceIssues, Integer maxPages) {
        try {
            String url = "https://api.github.com/repos/" + owner + "/" + repo;
            ProjectGHM projectGHM = restTemplate.getForObject(url, ProjectGHM.class);

            return projectGHM != null? transformer.transform(projectGHM, sinceCommits, sinceIssues, maxPages):null;
        } catch (Exception e) {
            System.err.println("Failed to obtain the project: " + e.getMessage());
            return null;
        }
    }

    /**
     * Función para enviar los datos a GitMiner
     */

    public Project sendProject(String owner, String repo, Integer sinceCommits, Integer sinceIssues, Integer maxPages) {
        try {
            Project projectToSend = getMapProject(owner, repo, sinceCommits, sinceIssues, maxPages);

            if (projectToSend == null) {
                throw new IllegalArgumentException("Project not found");
            }
            String gitMinerUrl = "http://localhost:8080/gitminer/projects";
            ResponseEntity<Project> response = restTemplate.postForEntity(gitMinerUrl, projectToSend, Project.class);

            if (response.getStatusCode() == HttpStatus.CREATED) {
                return response.getBody();
            } else {
                throw new IllegalStateException("Failed to create project: " + response.getStatusCode());
            }
        } catch (Exception e) {
            System.err.println("Failed to create project: " + e.getMessage());
            return null;
        }
    }


}
