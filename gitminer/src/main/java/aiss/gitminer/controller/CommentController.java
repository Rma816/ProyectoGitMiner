package aiss.gitminer.controller;

import aiss.gitminer.model.Comment;
import aiss.gitminer.repository.CommentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> findAll() {
        return ResponseEntity.ok(commentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable String id) {
        System.out.println("CommentId: " + id);
        return commentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
