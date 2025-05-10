package aiss.gitminer.controller;

import aiss.gitminer.model.Project;
import aiss.gitminer.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/gitminer/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    /**
     * Función para crear un proyecto en GitMiner
     */

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project saved = projectRepository.save(project);
        String newId = saved.getId().replace("{", "").replace("}", "");
        return ResponseEntity.created(URI.create("/projects/" + newId)).body(saved);
    }

    /**
     * Función para obtener todos los repositorios de GitMiner
     */

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(projectRepository.findAll());
    }

    /**
     * Función para obtener un Project a partir de su id
     */

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable String id) {
        return projectRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
