package aiss.githubminer.controller;

import aiss.githubminer.model.GitMiner.Project;
import aiss.githubminer.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/github")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // GET uri: http://localhost:8082/github/octocat/Hello-World

    @GetMapping("/{owner}/{repo}")
    public ResponseEntity<Project> getProject(
            @PathVariable String owner,
            @PathVariable String repo,
            @RequestParam(defaultValue = "2") Integer sinceCommits,
            @RequestParam(defaultValue = "20") Integer sinceIssues,
            @RequestParam(defaultValue = "2") Integer maxPages) {


        Project project = projectService.getMapProject(owner, repo, sinceCommits, sinceIssues, maxPages);
        return ResponseEntity.ok(project);
    }

//    @PostMapping("/{owner}/{repo}")
//    public ResponseEntity<String> sendToGitMiner(@PathVariable String owner,
//                                                 @PathVariable String repo) {
//        Project project = projectService.sendProject(owner, repo);
//        return ResponseEntity.ok(project.getName());
//    }
}
