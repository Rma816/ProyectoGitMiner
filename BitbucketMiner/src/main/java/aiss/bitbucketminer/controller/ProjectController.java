package aiss.bitbucketminer.controller;

import aiss.bitbucketminer.model.BitBucketProject;
import aiss.bitbucketminer.service.ProjectService;
import aiss.gitminer.model.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bitbucket")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{username}/{repoSlug}")
    public ResponseEntity<Project> getRepositoryInfo(
            @PathVariable String username,
            @PathVariable String repoSlug,
            @RequestParam(defaultValue = "5") int nCommits,
            @RequestParam(defaultValue = "5") int nIssues,
            @RequestParam(defaultValue = "2") int maxPages) {
        Project repo = projectService.getProject(username, repoSlug, nCommits, nIssues, maxPages);
        return ResponseEntity.ok(repo);
    }

    @PostMapping("/{username}/{repoSlug}")
    public ResponseEntity<Project> importProjectToGitMiner(
            @PathVariable String username,
            @PathVariable String repoSlug,
            @RequestParam(defaultValue = "5") int nCommits,
            @RequestParam(defaultValue = "5") int nIssues,
            @RequestParam(defaultValue = "2") int maxPages) {

        Project project = projectService.getProject(username, repoSlug, nCommits, nIssues, maxPages); // Paso 1 y 2: get + transform

        // Paso 3: Enviar a GitMiner
        String gitMinerUrl = "http://localhost:8080/gitminer/projects"; // Ajusta puerto/ruta si es diferente
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Project> response = restTemplate.postForEntity(gitMinerUrl, project, Project.class);

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}

