package aiss.githubminer.transformer;

import aiss.githubminer.model.CommentGHM;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.model.issueD.IssueLabel;

import aiss.githubminer.service.CommentService;
import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssueTransformer {

    public static Issue transform(IssueGHM issueGHM) {
        Issue issue = new Issue();
        issue.setId(issueGHM.getId() != null ? issueGHM.getId().toString() : null);
        issue.setTitle(issueGHM.getTitle() != null ? issueGHM.getTitle() : "No Title");
        issue.setDescription(issueGHM.getBody() != null ? issueGHM.getBody() : "No Body");
        issue.setState(issueGHM.getState() != null ? issueGHM.getState() : "No State");
        issue.setCreatedAt(issueGHM.getCreatedAt() != null ? issueGHM.getCreatedAt() : "No CreatedAt");
        issue.setUpdatedAt(issueGHM.getUpdatedAt() != null ? issueGHM.getUpdatedAt() : "No UpdatedAt");
        issue.setClosedAt(issueGHM.getClosedAt() != null ? issueGHM.getClosedAt() : "No ClosedAt");
        issue.setVotes(issueGHM.getComments() != null ? issueGHM.getComments() : 0);

        if (issueGHM.getUser() != null) {
            issue.setAuthor(UserTransformer.transformer(issueGHM.getUser()));
        } else {
            issue.setAuthor(null);
        }

        if (issueGHM.getAssignee() != null) {
            issue.setAssignee(UserTransformer.transformer(issueGHM.getAssignee()));
        } else {
            issue.setAssignee(null);
        }

        if (issueGHM.getLabels() != null) {
            List<String> labels = issueGHM.getLabels().stream().map(IssueLabel::getName).collect(Collectors.toList());
            issue.setLabels(labels);
        } else {
            issue.setLabels(null);
        }

        List<CommentGHM> commentGHMS = CommentService.getCommentsURL(issueGHM.getCommentsUrl());
        if (!commentGHMS.isEmpty()) {
            List<Comment> comments = commentGHMS.stream().map(CommentTransformer::transform).collect(Collectors.toList());
            issue.setComments(comments);
        } else {
            issue.setComments(null);
        }
        return issue;
    }

    public static List<Issue> transformList(List<IssueGHM> issuesGHM) {
        return issuesGHM.stream()
                .map(IssueTransformer::transform)
                .collect(Collectors.toList());
    }
}
