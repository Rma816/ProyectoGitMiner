package aiss.githubminer.model.commitD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitStats {

    @JsonProperty("additions")
    private Integer additions;

    @JsonProperty("deletions")
    private Integer deletions;

    @JsonProperty("total")
    private Integer total;

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

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }
}
