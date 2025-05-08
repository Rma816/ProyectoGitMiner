package aiss.bitbucketminer.model.dependencies.links;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Links_Issue {
    @JsonProperty("self")
    private Link self;
    @JsonProperty("html")
    private Link html;
    @JsonProperty("attachments")
    private Link attachments;
    @JsonProperty("watch")
    private Link watch;
    @JsonProperty("vote")
    private Link vote;
    @JsonProperty("comments")
    private Link comments;
}
