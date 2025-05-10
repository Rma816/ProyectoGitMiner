package aiss.gitminer.controller;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import aiss.gitminer.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/issues")
public class IssueController {

    @Autowired
    IssueRepository issueRepository;

    /**
     * Función para obtener todas las Issues de GitMiner
     */

    @GetMapping
    public ResponseEntity<List<Issue>> findAll() {
        return ResponseEntity.ok(issueRepository.findAll());
    }

    /**
     * Función para obtener un Issue a partir de su id
     */

    @GetMapping("/{id}")
    public ResponseEntity<Issue> findById(@PathVariable String id) {
        return issueRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Función para obtener todos los comentarios de una issue a partir de la IssueId
     */

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<Comment>> findCommentsByIssueId(@PathVariable String id) {
        return issueRepository.findById(id)
                .map(issue -> ResponseEntity.ok(issue.getComments()))
                .orElse(ResponseEntity.notFound().build());
    }

}
