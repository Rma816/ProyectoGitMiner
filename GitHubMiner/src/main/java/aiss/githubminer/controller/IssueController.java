package aiss.githubminer.controller;

import aiss.githubminer.model.GitMiner.Issue;
import aiss.githubminer.service.IssueService;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.transformer.IssueTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/github")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueTransformer transformer;

    // GET uri: http://localhost:8082/github/octocat/Hello-World/issues

    @GetMapping("/{owner}/{repo}/issues")
    public ResponseEntity<List<Issue>> getIssues(
            @PathVariable String owner,
            @PathVariable String repo) {

        List<IssueGHM> issues = issueService.getIssues(owner, repo);
        List<Issue> issueList = transformer.transformList(issues);
        return ResponseEntity.ok(issueList);
    }
}