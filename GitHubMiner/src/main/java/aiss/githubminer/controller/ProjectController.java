package aiss.githubminer.controller;

import aiss.githubminer.model.ProjectGHM;
import aiss.githubminer.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // GET uri: http://localhost:8082/github/octocat/Hello-World

    @GetMapping("/{owner}/{repo}")
    public ResponseEntity<ProjectGHM> getProject(@PathVariable String owner,
                                                            @PathVariable String repo) {
        ProjectGHM project = projectService.getProject(owner, repo);
        return ResponseEntity.ok(project);
    }
}
