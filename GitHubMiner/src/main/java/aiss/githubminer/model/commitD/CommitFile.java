package aiss.githubminer.model.commitD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitFile {

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("additions")
    private int additions;

    @JsonProperty("deletions")
    private int deletions;

    @JsonProperty("changes")
    private int changes;

    @JsonProperty("status")
    private String status;

    @JsonProperty("raw_url")
    private String raw_url;

    @JsonProperty("blob_url")
    private String blob_url;

    @JsonProperty("patch")
    private String patch;

    // Getters
    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("additions")
    public int getAdditions() {
        return additions;
    }

    @JsonProperty("deletions")
    public int getDeletions() {
        return deletions;
    }

    @JsonProperty("changes")
    public int getChanges() {
        return changes;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("raw_url")
    public String getRaw_url() {
        return raw_url;
    }

    @JsonProperty("blob_url")
    public String getBlob_url() {
        return blob_url;
    }

    @JsonProperty("patch")
    public String getPatch() {
        return patch;
    }

    // Setters
    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("additions")
    public void setAdditions(int additions) {
        this.additions = additions;
    }

    @JsonProperty("deletions")
    public void setDeletions(int deletions) {
        this.deletions = deletions;
    }

    @JsonProperty("changes")
    public void setChanges(int changes) {
        this.changes = changes;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("raw_url")
    public void setRaw_url(String raw_url) {
        this.raw_url = raw_url;
    }

    @JsonProperty("blob_url")
    public void setBlob_url(String blob_url) {
        this.blob_url = blob_url;
    }

    @JsonProperty("patch")
    public void setPatch(String patch) {
        this.patch = patch;
    }
}
