package aiss.githubminer.service;

import aiss.githubminer.model.CommitGHM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommitServiceTest {

    @Autowired
    private CommitService commitService;

    @Test
    @DisplayName("Get commits of a repo - octocat/Hello-World")
    void getAllCommits() {
        String owner = "octocat";
        String repo = "Hello-World";

        List<CommitGHM> commits = commitService.getAllCommits(owner, repo);

        assertNotNull(commits, "La lista de commits no debe ser nula");
        assertFalse(commits.isEmpty(), "La lista de commits no debe estar vacía");

        CommitGHM firstCommit = commits.get(0);
        assertNotNull(firstCommit.getCommit().getAuthor(), "El commit debe tener un ID");
        assertNotNull(firstCommit.getCommit().getMessage(), "El commit debe tener un mensaje");
        System.out.println(firstCommit);
    }
}