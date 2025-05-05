package aiss.githubminer.model.commitD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitDetails {

    @JsonProperty("message")
    private String message;

    @JsonProperty("author")
    private CommitAuthor author;

    @JsonProperty("committer")
    private CommitAuthor committer;

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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
}
