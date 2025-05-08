package aiss.githubminer.service;

import aiss.githubminer.model.ProjectGHM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    @Test
    @DisplayName("Get a GitHub project - 1")
    void getProject() {
        // Datos de entrada
        String owner = "octocat";
        String repo = "Hello-World";

        // Ejecución
        ProjectGHM project = projectService.getProject(owner, repo);

        // Aserciones básicas
        assertNotNull(project, "El proyecto no debería ser nulo");
        assertNotNull(project.getId(), "El proyecto debe tener ID");
        assertNotNull(project.getName(), "El proyecto debe tener nombre");

        // Opcional: imprimir para ver el resultado
        System.out.println(project.getName());
        System.out.println(project.getId());
        System.out.println("Proyecto octocat: \n" + project);
    }
}
