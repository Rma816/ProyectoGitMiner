package aiss.gitminer.controller;

import aiss.gitminer.service.CommitService;
import aiss.gitminer.model.Commit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/commits")
public class CommitController {

    private final CommitService commitService;

    public CommitController(CommitService commitService) {
        this.commitService = commitService;
    }
    /**
     * Obtiene todos los commits de gitminer
     */
    @GetMapping()
    public ResponseEntity<List<Commit>> getCommits() {
        List<Commit> commits = commitService.getCommits();
        return ResponseEntity.ok(commits);
    }
    /**
     * Obtiene un commit específico desde Gitminer.
     */
    @GetMapping("/{commitId}")
    public ResponseEntity<Commit> getCommit(@PathVariable String commitId) {
        Commit commit = commitService.getCommit(commitId);
        return ResponseEntity.ok(commit);
    }

    /**
     * Función para crear commits
     */

    @PostMapping()
    public ResponseEntity<List<Commit>> createCommits(@RequestBody List<Commit> commits) {
        commitService.createCommits(commits);
        return ResponseEntity.ok(commits);
    }
}
