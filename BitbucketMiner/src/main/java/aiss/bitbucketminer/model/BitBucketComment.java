package aiss.bitbucketminer.model;

import aiss.bitbucketminer.model.dependencies.Content;
import aiss.bitbucketminer.model.dependencies.links.Links_Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BitBucketComment {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("content")
    private Content content;
    private String raw;
    @JsonProperty("created_on")
    private String created_at;
    @JsonProperty("updated_on")
    private String updated_at;
    @JsonProperty("user")
    private BitBucketUser user;
    @JsonProperty("issue")
    private BitBucketIssue issue;

    public String getRaw() {
        return content != null ? content.getRaw() : null;
    }


}
