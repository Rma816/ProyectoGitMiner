package aiss.gitminer.service;

import java.util.List;

import java.util.ArrayList;
import aiss.gitminer.model.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    List<Comment> comments = new ArrayList<>();
    public List<Comment> getComments() {
        return comments;
    }
    public Comment getComment(String id) {
        return comments.stream()
                .filter(comment -> comment.getId().equals(id))
                .findFirst()
                .orElse(null); // o lanzar una excepción si no se encuentra el comentario
    }
    public Comment createComment(Comment comment) {
        if (comment != null) comments.add(comment);
        return comment;
    }
    public void createComments(List<Comment> comments) {
        if (!comments.isEmpty()) this.comments.addAll(comments);
    }
}