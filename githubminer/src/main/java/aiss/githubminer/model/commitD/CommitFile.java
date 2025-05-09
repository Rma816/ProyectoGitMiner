package aiss.githubminer.model.commitD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitFile {

    @JsonProperty("filename")
    private String filename;
    @JsonProperty("additions")
    private Integer additions;
    @JsonProperty("deletions")
    private Integer deletions;
    @JsonProperty("changes")
    private Integer changes;
    @JsonProperty("status")
    private String status;
    @JsonProperty("raw_url")
    private String rawUrl;
    @JsonProperty("blob_url")
    private String blobUrl;
    @JsonProperty("patch")
    private String patch;

    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("additions")
    public Integer getAdditions() {
        return additions;
    }

    @JsonProperty("additions")
    public void setAdditions(Integer additions) {
        this.additions = additions;
    }

    @JsonProperty("deletions")
    public Integer getDeletions() {
        return deletions;
    }

    @JsonProperty("deletions")
    public void setDeletions(Integer deletions) {
        this.deletions = deletions;
    }

    @JsonProperty("changes")
    public Integer getChanges() {
        return changes;
    }

    @JsonProperty("changes")
    public void setChanges(Integer changes) {
        this.changes = changes;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("raw_url")
    public String getRawUrl() {
        return rawUrl;
    }

    @JsonProperty("raw_url")
    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    @JsonProperty("blob_url")
    public String getBlobUrl() {
        return blobUrl;
    }

    @JsonProperty("blob_url")
    public void setBlobUrl(String blobUrl) {
        this.blobUrl = blobUrl;
    }

    @JsonProperty("patch")
    public String getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(String patch) {
        this.patch = patch;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommitFile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("filename");
        sb.append('=');
        sb.append(((this.filename == null)?"<null>":this.filename));
        sb.append(',');
        sb.append("additions");
        sb.append('=');
        sb.append(((this.additions == null)?"<null>":this.additions));
        sb.append(',');
        sb.append("deletions");
        sb.append('=');
        sb.append(((this.deletions == null)?"<null>":this.deletions));
        sb.append(',');
        sb.append("changes");
        sb.append('=');
        sb.append(((this.changes == null)?"<null>":this.changes));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("rawUrl");
        sb.append('=');
        sb.append(((this.rawUrl == null)?"<null>":this.rawUrl));
        sb.append(',');
        sb.append("blobUrl");
        sb.append('=');
        sb.append(((this.blobUrl == null)?"<null>":this.blobUrl));
        sb.append(',');
        sb.append("patch");
        sb.append('=');
        sb.append(((this.patch == null)?"<null>":this.patch));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
