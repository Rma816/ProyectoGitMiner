package aiss.bitbucketminer.model;

import aiss.bitbucketminer.model.containers.BitBucketCommitContainer;
import aiss.bitbucketminer.model.containers.BitBucketIssueContainer;
import aiss.bitbucketminer.model.dependencies.links.Links_Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static aiss.bitbucketminer.service.CommitService.getCommitFromUrl;
import static aiss.bitbucketminer.service.IssueService.getIssuesFromUrl;

@Data
public class BitBucketProject {
    @JsonProperty("uuid")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("website")
    private String web_url;
    @JsonProperty("links")
    private Links_Project links;
    private BitBucketCommitContainer commits;
    private BitBucketIssueContainer issues;

    public BitBucketCommitContainer getCommits() {
        return links != null ? getCommitFromUrl(links.getCommits().getHref()) : null;
    }

    public BitBucketIssueContainer getIssues() {
        return links != null ? getIssuesFromUrl(links.getIssues().getHref()) : null;
    }
}



