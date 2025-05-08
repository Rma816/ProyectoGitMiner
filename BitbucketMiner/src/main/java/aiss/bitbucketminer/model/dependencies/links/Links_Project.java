package aiss.bitbucketminer.model.dependencies.links;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Links_Project {
    @JsonProperty("self")
    private Link self;
    @JsonProperty("html")
    private Link html;
    @JsonProperty("watchers")
    private Link watch;
    @JsonProperty("avatar")
    private Link avatar;
    @JsonProperty("commits")
    private Link commits;
    @JsonProperty("issues")
    private Link issues;


}
