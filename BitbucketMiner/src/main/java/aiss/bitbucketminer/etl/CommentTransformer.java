package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.BitBucketComment;
import aiss.gitminer.model.Comment;

public class CommentTransformer {

    public static Comment transformComment (BitBucketComment comment) {
        Comment newComment = new Comment();
        newComment.setId(comment.getId().toString());
        newComment.setBody(comment.getRaw());
        newComment.setCreatedAt(comment.getCreated_at());
        newComment.setUpdatedAt(comment.getUpdated_at());
        newComment.setAuthor(UserTransformer.transformUser(comment.getUser()));
        return newComment;
    }
}
