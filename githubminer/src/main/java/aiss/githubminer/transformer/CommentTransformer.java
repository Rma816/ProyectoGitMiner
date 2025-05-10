package aiss.githubminer.transformer;

import aiss.githubminer.model.CommentGHM;
import aiss.githubminer.model.GitMiner.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentTransformer {

    public static Comment transform(CommentGHM commitGHM) {
        Comment comment = new Comment();
        comment.setId(String.valueOf(commitGHM.getId()));
        comment.setBody(commitGHM.getBody());
        comment.setAuthor(UserTransformer.transformer(commitGHM.getUser()));
        comment.setCreatedAt(commitGHM.getCreatedAt());
        comment.setUpdatedAt(commitGHM.getUpdatedAt());
        return comment;
    }

    public static List<Comment> transformList(List<CommentGHM> commitGHMs) {
        return commitGHMs.stream().map(CommentTransformer::transform).collect(Collectors.toList());
    }
}
