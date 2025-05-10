package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.BitBucketComment;
import aiss.gitminer.model.Comment;

public class CommentTransformer {

    public static Comment transformComment (BitBucketComment comment) {
        Comment newComment = new Comment();
        newComment.setId(comment.getId() != null ? Long.valueOf(comment.getId()) : null);
        newComment.setBody(comment.getRaw() != null ? comment.getRaw() : "No content");
        newComment.setCreatedAt(comment.getCreated_at() != null ? comment.getCreated_at() : "No date");
        newComment.setUpdatedAt(comment.getUpdated_at() != null ? comment.getUpdated_at() : "No date");
        newComment.setAuthor(comment.getUser() != null ? UserTransformer.transformUser(comment.getUser()) : null);
        return newComment;
    }
}
