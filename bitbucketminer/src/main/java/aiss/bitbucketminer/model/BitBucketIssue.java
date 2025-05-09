package aiss.bitbucketminer.model;

import aiss.bitbucketminer.model.containers.BitBucketCommentContainer;
import aiss.bitbucketminer.model.dependencies.Content;
import aiss.bitbucketminer.model.dependencies.links.Links_Issue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static aiss.bitbucketminer.service.CommentService.obtenerCommentDesdeUrl;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketIssue {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private Content content;
    private String description;
    @JsonProperty("state")
    private String state;
    @JsonProperty("created_on")
    private String created_at;
    @JsonProperty("updated_on")
    private String updated_at;
    @JsonProperty("edited_on")
    private String closed_at;
    @JsonProperty("kind")
    private String kind;
    private List<String> labels;
    @JsonProperty("votes")
    private Integer votes;
    @JsonProperty("links")
    private Links_Issue links;
    private BitBucketCommentContainer comments;
    @JsonProperty("reporter")
    private BitBucketUser author;
    @JsonProperty("assignee")
    private BitBucketUser assignee;

    public String getDescription() {
        return content != null ? content.getRaw() : null;
    }

    public List<String> getLabels() {
        List<String> labels = new ArrayList<>();
        labels.add(kind);
        return labels;
    }

    public BitBucketCommentContainer getComments() {
        return links != null ? obtenerCommentDesdeUrl(links.getComments().getHref()) : null;
    }

    public BitBucketUser getAuthor() {
        return author != null ? author : null;
    }

    public BitBucketUser getAssignee() {
        return assignee != null ? assignee : null;
    }
}
