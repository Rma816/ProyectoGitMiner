package aiss.githubminer.controller;

import aiss.githubminer.service.IssueService;
import aiss.githubminer.model.IssueGHM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping("/{owner}/{repo}")
    public ResponseEntity<List<IssueGHM>> getIssues(
            @PathVariable String owner,
            @PathVariable String repo) {

        List<IssueGHM> issues = issueService.getIssues(owner, repo);
        return ResponseEntity.ok(issues);
    }
}