package aiss.gitminer.service;

import java.util.List;
import java.util.ArrayList;
import aiss.gitminer.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    List<Project> projects = new ArrayList<>(); // List of imported Project objects
    public List<Project> getProjects() {
        return projects;
    }
    public Project getProject(String id) {
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst()
                .orElse(null); // o lanzar una excepción si no se encuentra el proyecto
    }
    public Project createProject(Project project) {
        projects.add(project);
        return project;
    }
}
