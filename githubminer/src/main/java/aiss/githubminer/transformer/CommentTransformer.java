package aiss.githubminer.transformer;

import aiss.githubminer.model.CommentGHM;
import aiss.gitminer.model.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentTransformer {

    public static Comment transform(CommentGHM commentGHM) {
        Comment comment = new Comment();
        comment.setId(Long.valueOf(commentGHM.getId() != null ? commentGHM.getId().toString() : "No ID"));
        comment.setBody(commentGHM.getBody() != null ? commentGHM.getBody() : "No Body");
        comment.setCreatedAt(commentGHM.getCreatedAt() != null ? commentGHM.getCreatedAt() : "No Created At");
        comment.setUpdatedAt(commentGHM.getUpdatedAt() != null ? commentGHM.getUpdatedAt() : "No Updated At");

        if (commentGHM.getUser() != null) {
            comment.setAuthor(UserTransformer.transformer(commentGHM.getUser()));
        } else {
            comment.setAuthor(null);
        }
        return comment;
    }

    public static List<Comment> transformList(List<CommentGHM> commitGHMs) {
        return !commitGHMs.isEmpty() ? commitGHMs.stream()
                .map(CommentTransformer::transform)
                .collect(Collectors.toList()) : new ArrayList<>();
    }
}
