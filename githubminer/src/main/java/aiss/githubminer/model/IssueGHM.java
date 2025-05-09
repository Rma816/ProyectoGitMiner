package aiss.githubminer.model;

import aiss.githubminer.model.issueD.IssueLabel;
import aiss.githubminer.model.issueD.IssueMilestone;
import aiss.githubminer.model.issueD.IssuePullRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueGHM {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("url")
    private String url;

    @JsonProperty("repository_url")
    private String repositoryUrl;

    @JsonProperty("labels_url")
    private String labelsUrl;

    @JsonProperty("comments_url")
    private String commentsUrl;

    @JsonProperty("events_url")
    private String eventsUrl;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("state")
    private String state;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    @JsonProperty("user")
    private UserGHM user;

    @JsonProperty("labels")
    private List<IssueLabel> labels;

    @JsonProperty("assignee")
    private UserGHM assignee;

    @JsonProperty("assignees")
    private List<UserGHM> assignees;

    @JsonProperty("milestone")
    private IssueMilestone milestone;

    @JsonProperty("locked")
    private Boolean locked;

    @JsonProperty("active_lock_reason")
    private String activeLockReason;

    @JsonProperty("comments")
    private Integer comments;

    @JsonProperty("pull_request")
    private IssuePullRequest pullRequest;

    @JsonProperty("closed_at")
    private String closedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("closed_by")
    private UserGHM closedBy;

    @JsonProperty("author_association")
    private String authorAssociation;

    @JsonProperty("state_reason")
    private String stateReason;

    public IssueGHM() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNodeId() { return nodeId; }
    public void setNodeId(String nodeId) { this.nodeId = nodeId; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getRepositoryUrl() { return repositoryUrl; }
    public void setRepositoryUrl(String repositoryUrl) { this.repositoryUrl = repositoryUrl; }

    public String getLabelsUrl() { return labelsUrl; }
    public void setLabelsUrl(String labelsUrl) { this.labelsUrl = labelsUrl; }

    public String getCommentsUrl() { return commentsUrl; }
    public void setCommentsUrl(String commentsUrl) { this.commentsUrl = commentsUrl; }

    public String getEventsUrl() { return eventsUrl; }
    public void setEventsUrl(String eventsUrl) { this.eventsUrl = eventsUrl; }

    public String getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public UserGHM getUser() { return user; }
    public void setUser(UserGHM user) { this.user = user; }

    public List<IssueLabel> getLabels() { return labels; }
    public void setLabels(List<IssueLabel> labels) { this.labels = labels; }

    public UserGHM getAssignee() { return assignee; }
    public void setAssignee(UserGHM assignee) { this.assignee = assignee; }

    public List<UserGHM> getAssignees() { return assignees; }
    public void setAssignees(List<UserGHM> assignees) { this.assignees = assignees; }

    public IssueMilestone getMilestone() { return milestone; }
    public void setMilestone(IssueMilestone milestone) { this.milestone = milestone; }

    public Boolean getLocked() { return locked; }
    public void setLocked(Boolean locked) { this.locked = locked; }

    public String getActiveLockReason() { return activeLockReason; }
    public void setActiveLockReason(String activeLockReason) { this.activeLockReason = activeLockReason; }

    public Integer getComments() { return comments; }
    public void setComments(Integer comments) { this.comments = comments; }

    public IssuePullRequest getPullRequest() { return pullRequest; }
    public void setPullRequest(IssuePullRequest pullRequest) { this.pullRequest = pullRequest; }

    public String getClosedAt() { return closedAt; }
    public void setClosedAt(String closedAt) { this.closedAt = closedAt; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public UserGHM getClosedBy() { return closedBy; }
    public void setClosedBy(UserGHM closedBy) { this.closedBy = closedBy; }

    public String getAuthorAssociation() { return authorAssociation; }
    public void setAuthorAssociation(String authorAssociation) { this.authorAssociation = authorAssociation; }

    public String getStateReason() { return stateReason; }
    public void setStateReason(String stateReason) { this.stateReason = stateReason; }

    @Override
    public String toString() {
        return String.format("IssueDTO{id=%d, number=%d, state='%s', title='%s', user='%s', comments=%d}", id, number, state, title, user.getLogin(), comments);
    }
}