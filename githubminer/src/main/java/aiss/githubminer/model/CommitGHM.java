package aiss.githubminer.model;

import java.util.List;

import aiss.githubminer.model.commitD.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitGHM {

    @JsonProperty("url")
    private String url;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("commit")
    private CommitDetails commit;
    @JsonProperty("author")
    private CommitAuthor author;
    @JsonProperty("committer")
    private CommitAuthor committer;
    @JsonProperty("parents")
    private List<CommitParent> parents;
    @JsonProperty("stats")
    private CommitStats stats;
    @JsonProperty("files")
    private List<CommitFile> files;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("node_id")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("node_id")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    @JsonProperty("commit")
    public CommitDetails getCommit() {
        return commit;
    }

    @JsonProperty("commit")
    public void setCommit(CommitDetails commit) {
        this.commit = commit;
    }

    @JsonProperty("author")
    public CommitAuthor getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(CommitAuthor author) {
        this.author = author;
    }

    @JsonProperty("committer")
    public CommitAuthor getCommitter() {
        return committer;
    }

    @JsonProperty("committer")
    public void setCommitter(CommitAuthor committer) {
        this.committer = committer;
    }

    @JsonProperty("parents")
    public List<CommitParent> getParents() {
        return parents;
    }

    @JsonProperty("parents")
    public void setParents(List<CommitParent> parents) {
        this.parents = parents;
    }

    @JsonProperty("stats")
    public CommitStats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(CommitStats stats) {
        this.stats = stats;
    }

    @JsonProperty("files")
    public List<CommitFile> getFiles() {
        return files;
    }

    @JsonProperty("files")
    public void setFiles(List<CommitFile> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommitGHM.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("sha");
        sb.append('=');
        sb.append(((this.sha == null)?"<null>":this.sha));
        sb.append(',');
        sb.append("nodeId");
        sb.append('=');
        sb.append(((this.nodeId == null)?"<null>":this.nodeId));
        sb.append(',');
        sb.append("htmlUrl");
        sb.append('=');
        sb.append(((this.htmlUrl == null)?"<null>":this.htmlUrl));
        sb.append(',');
        sb.append("commentsUrl");
        sb.append('=');
        sb.append(((this.commentsUrl == null)?"<null>":this.commentsUrl));
        sb.append(',');
        sb.append("commit");
        sb.append('=');
        sb.append(((this.commit == null)?"<null>":this.commit));
        sb.append(',');
        sb.append("author");
        sb.append('=');
        sb.append(((this.author == null)?"<null>":this.author));
        sb.append(',');
        sb.append("committer");
        sb.append('=');
        sb.append(((this.committer == null)?"<null>":this.committer));
        sb.append(',');
        sb.append("parents");
        sb.append('=');
        sb.append(((this.parents == null)?"<null>":this.parents));
        sb.append(',');
        sb.append("stats");
        sb.append('=');
        sb.append(((this.stats == null)?"<null>":this.stats));
        sb.append(',');
        sb.append("files");
        sb.append('=');
        sb.append(((this.files == null)?"<null>":this.files));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}