package aiss.githubminer.service;

import aiss.githubminer.model.IssueGHM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueServiceTest {

    @Autowired
    IssueService issueService;

    @Test
    @DisplayName("Get commits of a repo - 1")
    void getIssues() {
        // Configuración mínima para que funcione
        String owner = "octocat";
        String repo = "Hello-World";

        // Ejecución (igual que tu versión)
        List<IssueGHM> issues = issueService.getIssues(owner, repo);

        // Aserciones (tus comprobaciones originales)
        assertNotNull(issues, "La lista de issues no debería ser nula");
        assertFalse(issues.isEmpty(), "La lista de issues no debería estar vacía");
        // assertEquals(3, issues.size(), "Deberían haber exactamente 3 issues (no se cuantas deben haber)");

        // Verificación adicional mínima del primer issue (opcional)
        IssueGHM firstIssue = issues.get(0);
        assertNotNull(firstIssue.getId(), "El issue debe tener ID");
        assertNotNull(firstIssue.getTitle(), "El issue debe tener título");
        System.out.println(issues.size());
        System.out.println(firstIssue);
    }


}