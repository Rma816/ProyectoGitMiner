package aiss.githubminer.transformer;

import aiss.githubminer.model.CommentGHM;
import aiss.githubminer.model.CommitGHM;
import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Commit;

public class CommentTransformer {

    public static Comment transform(CommentGHM commitGHM) {
        Comment comment = new Comment();
        comment.setId(String.valueOf(commitGHM.getId())); // TODO: getId o getNodeId?
        comment.setBody(commitGHM.getBody());
        comment.setAuthor(comment.getAuthor());
        return comment;
    }
}
