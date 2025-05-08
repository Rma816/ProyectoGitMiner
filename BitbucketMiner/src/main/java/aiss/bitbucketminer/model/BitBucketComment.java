package aiss.bitbucketminer.model;

import aiss.bitbucketminer.model.dependencies.Content;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
