package aiss.bitbucketminer.model;

import aiss.bitbucketminer.model.dependencies.links.Links_Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BitBucketUser {
    @JsonProperty("uuid")
    private String id;
    @JsonProperty("nickname")
    private String username;
    @JsonProperty("display_name")
    private String name;
    @JsonProperty("links")
    private Links_Project links;
    private String avatar_url;
    private String web_url;

    public String getAvatar_url() {
        return links != null ? links.getAvatar().getHref() : null;
    }

    public String getWeb_url() {
        return links != null ? links.getSelf().getHref() : null;
    }

}
