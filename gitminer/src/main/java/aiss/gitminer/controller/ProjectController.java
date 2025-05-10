package aiss.gitminer.controller;

import aiss.gitminer.model.Project;
import aiss.gitminer.model.User;
import aiss.gitminer.model.Issue;

import aiss.gitminer.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final CommitService commitService;
    private final IssueService issueService;
    private final CommentService commentService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, CommitService commitService, IssueService issueService, CommentService commentService, UserService userService) {
        this.projectService = projectService;
        this.commitService = commitService;
        this.issueService = issueService;
        this.commentService = commentService;
        this.userService = userService;
    }
    /*
     * Obtiene todos los proyectos de gitminer
     */
    @GetMapping()
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.getProjects();
        return ResponseEntity.ok(projects);
    }
    /*
     * Obtiene un proyecto específico desde Gitminer.
     */
    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable String projectId) {
        Project project = projectService.getProject(projectId);
        return ResponseEntity.ok(project);
    }
    /*
     * Crea un nuevo proyecto en Gitminer.
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProject(@RequestBody Project project) {
        // Imprime los datos del proyecto para asegurarse de que no está vacío
        System.out.println("Datos del proyecto a enviar: " + project);

        Project createdProject = projectService.createProject(project);
        commitService.createCommits(createdProject.getCommits());

        List<Issue> createdIssues = issueService.createIssues(createdProject.getIssues());
        createdIssues.forEach(issue -> {
            User userIssue = issue.getAuthor();
            if (userIssue != null) {
                userService.createUser(userIssue);
            }

            if (issue.getComments() != null && !issue.getComments().isEmpty()) {
                commentService.createComments(issue.getComments());
                issue.getComments().forEach(comment -> {
                    User userComment = comment.getAuthor();
                    if (userComment != null) {
                        userService.createUser(userComment);
                    }
                });
            }
        });
    }

}