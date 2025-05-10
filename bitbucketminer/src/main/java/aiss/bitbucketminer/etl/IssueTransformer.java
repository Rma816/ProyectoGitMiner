package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.BitBucketIssue;
import aiss.gitminer.model.Issue;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static aiss.bitbucketminer.etl.UserTransformer.transformUser;

public class IssueTransformer {

    public static Issue transformIssue (BitBucketIssue issue) {
        Issue newIssue = new Issue();
        newIssue.setAssignee(issue.getAssignee() != null ? transformUser(issue.getAssignee()) : null);
        newIssue.setAuthor(issue.getAuthor() != null ? transformUser(issue.getAuthor()) : null);
        newIssue.setClosedAt(issue.getClosed_at() != null ? issue.getClosed_at() : "No date");
        newIssue.setId(issue.getId() != null ? issue.getId().toString() : "No issue");
        newIssue.setDescription(issue.getDescription() != null ? issue.getDescription() : "No description");
        newIssue.setTitle(issue.getTitle() != null ? issue.getTitle() : "No title");
        newIssue.setState(issue.getState() != null ? issue.getState() : "No state");
        newIssue.setLabels(issue.getLabels() != null ? issue.getLabels() : new ArrayList<>());
        newIssue.setVotes(issue.getVotes() != null ? issue.getVotes() : null);
        newIssue.setUpdatedAt(issue.getUpdated_at() != null ? issue.getUpdated_at() : "No updated date");
        newIssue.setCreatedAt(issue.getCreated_at() != null ? issue.getCreated_at() : "No created date");
        if (!issue.getComments().getComments().isEmpty()) {
            newIssue.setComments(issue.getComments().getComments().stream().map(CommentTransformer::transformComment).collect(Collectors.toList()));
        }
        return newIssue;
    }
}
