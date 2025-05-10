package aiss.gitminer.controller;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import aiss.gitminer.repository.IssueRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/issues")
public class IssueController {

    private final IssueRepository issueRepository;

    public IssueController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @GetMapping
    public ResponseEntity<List<Issue>> findAll() {
        return ResponseEntity.ok(issueRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> findById(@PathVariable String id) {
        return issueRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<Comment>> findCommentsByIssueId(@PathVariable String id) {
        return issueRepository.findById(id)
                .map(issue -> ResponseEntity.ok(issue.getComments()))
                .orElse(ResponseEntity.notFound().build());
    }

}
