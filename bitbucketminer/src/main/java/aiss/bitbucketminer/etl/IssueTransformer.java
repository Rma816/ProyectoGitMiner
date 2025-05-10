package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.BitBucketIssue;
import aiss.bitbucketminer.model.GitMiner.Issue;

import java.util.stream.Collectors;

import static aiss.bitbucketminer.etl.UserTransformer.transformUser;

public class IssueTransformer {

    public static Issue transformIssue (BitBucketIssue issue) {
        Issue newIssue = new Issue();
        newIssue.setAssignee(transformUser(issue.getAssignee()));
        newIssue.setAuthor(transformUser(issue.getAuthor()));
        newIssue.setClosedAt(issue.getClosed_at());
        newIssue.setId(issue.getId());
        newIssue.setDescription(issue.getDescription());
        newIssue.setTitle(issue.getTitle());
        newIssue.setState(issue.getState());
        newIssue.setLabels(issue.getLabels());
        newIssue.setVotes(issue.getVotes());
        newIssue.setUpdatedAt(issue.getUpdated_at());
        newIssue.setCreatedAt(issue.getCreated_at());
        newIssue.setComments(issue.getComments().getComments().stream().map(CommentTransformer::transformComment).collect(Collectors.toList()));
        return newIssue;
    }
}
