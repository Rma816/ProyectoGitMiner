package aiss.githubminer.model.commitD;

import com.sun.source.tree.Tree;

public class CommitDetails {
    private String url;
    private CommitAuthor author;
    private CommitAuthor committer;
    private String message;
    private Tree tree;
    private int comment_count;
    private CommitVerification verification;

    // Getters y setters
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public CommitAuthor getAuthor() { return author; }
    public void setAuthor(CommitAuthor author) { this.author = author; }

    public CommitAuthor getCommitter() { return committer; }
    public void setCommitter(CommitAuthor committer) { this.committer = committer; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Tree getTree() { return tree; }
    public void setTree(Tree tree) { this.tree = tree; }

    public int getComment_count() { return comment_count; }
    public void setComment_count(int comment_count) { this.comment_count = comment_count; }

    public CommitVerification getVerification() { return verification; }
    public void setVerification(CommitVerification verification) { this.verification = verification; }
}