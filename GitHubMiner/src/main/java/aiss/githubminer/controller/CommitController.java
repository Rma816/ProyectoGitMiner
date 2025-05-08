package aiss.githubminer.controller;

import aiss.githubminer.model.CommitGHM;
import aiss.githubminer.service.CommitService;
import aiss.githubminer.service.IssueService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/github")
public class CommitController {

    @Autowired
    private CommitService commitService;

    // GET uri: http://localhost:8082/github/octocat/Hello-World/commits

    @GetMapping("/{owner}/{repo}/commits")
    public ResponseEntity<List<CommitGHM>> getAllCommitsGHM(@PathVariable String owner,
                                                            @PathVariable String repo) {
        List<CommitGHM> commits = commitService.getAllCommits(owner, repo);
        return ResponseEntity.ok(commits);
    }
}


