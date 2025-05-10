package aiss.gitminer.controller;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import aiss.gitminer.service.IssueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    /**
     * Obtiene todos los issues de gitminer
     */
    @GetMapping()
    public ResponseEntity<List<Issue>> getIssues() {
        List<Issue> issues = issueService.getIssues();
        return ResponseEntity.ok(issues);
    }
    /**
     * Obtiene un issue específico desde Gitminer.
     */
    @GetMapping("/{issueId}")
    public ResponseEntity<Issue> getIssue(@PathVariable String issueId) {
        Issue issue = issueService.getIssue(issueId);
        return ResponseEntity.ok(issue);
    }
    /**
     * Obtiene los comentarios de un issue específico desde Gitminer.
     */
    @GetMapping("/{issueId}/comments")
    public ResponseEntity<List<Comment>> getIssueComments(@PathVariable String issueId) {
        List<Comment> comments = issueService.getIssueComments(issueId);
        return ResponseEntity.ok(comments);
    }
    /**
     * Obtiene los issues de un usuario específico desde Gitminer.
     */
    @GetMapping("?userId={userId}")
    public ResponseEntity<List<Issue>> getIssuesByUser(@RequestParam String userId) {
        List<Issue> issues = issueService.getIssuesByUser(userId);
        return ResponseEntity.ok(issues);
    }
    /**
     * Obtiene los issues con un estado específico desde Gitminer.
     */
    @GetMapping("?state={state}")
    public ResponseEntity<List<Issue>> getIssuesByState(@RequestParam String state) {
        List<Issue> issues = issueService.getIssuesByState(state);
        return ResponseEntity.ok(issues);
    }

    /**
     * Función para crear Issues
     */

    @PostMapping()
    public ResponseEntity<List<Issue>> createIssue(@RequestBody List<Issue> issues) {
        issueService.createIssues(issues);
        return ResponseEntity.ok(issues);
    }
}
