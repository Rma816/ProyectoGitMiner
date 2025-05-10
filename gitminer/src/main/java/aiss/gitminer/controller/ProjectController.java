package aiss.gitminer.controller;

import aiss.gitminer.model.Project;
import aiss.gitminer.repository.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/gitminer/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project saved = projectRepository.save(project);
        String newId = saved.getId().replace("{", "").replace("}", "");
        return ResponseEntity.created(URI.create("/projects/" + newId)).body(saved);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(projectRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable String id) {
        return projectRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
