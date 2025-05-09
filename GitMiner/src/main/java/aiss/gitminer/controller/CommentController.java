package aiss.gitminer.controller;

import aiss.gitminer.model.Comment;
import aiss.gitminer.service.CommentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Obtiene los comentarios de un issue específico desde Gitminer, sin transformación.
     */
    @GetMapping()
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> comments = commentService.getComments();
        return ResponseEntity.ok(comments);
    }
    /**
     * Obtiene un comentario específico desde Gitminer.
     */
    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable String commentId) {
        Comment comment = commentService.getComment(commentId);
        return ResponseEntity.ok(comment);
    }

}

