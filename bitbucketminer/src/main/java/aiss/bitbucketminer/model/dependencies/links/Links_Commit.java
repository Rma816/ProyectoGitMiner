package aiss.bitbucketminer.model.dependencies.links;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Links_Commit {
    @JsonProperty("self")
    private Link self;
    @JsonProperty("html")
    private Link html;
}
