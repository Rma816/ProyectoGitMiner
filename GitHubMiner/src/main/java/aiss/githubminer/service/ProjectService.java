package aiss.githubminer.service;

import aiss.githubminer.model.ProjectGHM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    public ProjectGHM getProject(String owner, String repo) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo;
        return restTemplate.getForObject(url, ProjectGHM.class);
    }
}
