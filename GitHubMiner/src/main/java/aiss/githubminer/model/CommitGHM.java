package aiss.githubminer.model;

import aiss.githubminer.model.commitD.CommitDetails;
import aiss.githubminer.model.commitD.CommitFile;
import aiss.githubminer.model.commitD.CommitParent;
import aiss.githubminer.model.commitD.CommitStats;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitGHM {

    @JsonProperty("sha")
    private String sha;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("commit")
    private CommitDetails commit;

    @JsonProperty("author") //TODO: no se si es user o CommitAuthor
    private User author;

    @JsonProperty("committer")
    private User committer;

    @JsonProperty("stats")
    private CommitStats stats;

    @JsonProperty("files")
    private List<CommitFile> files;

    @JsonProperty("parents")
    private List<CommitParent> parents;

    // Getters and setters

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
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
    public User getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(User author) {
        this.author = author;
    }

    @JsonProperty("committer")
    public User getCommitter() {
        return committer;
    }

    @JsonProperty("committer")
    public void setCommitter(User committer) {
        this.committer = committer;
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

    @JsonProperty("parents")
    public List<CommitParent> getParents() {
        return parents;
    }

    @JsonProperty("parents")
    public void setParents(List<CommitParent> parents) {
        this.parents = parents;
    }
}
