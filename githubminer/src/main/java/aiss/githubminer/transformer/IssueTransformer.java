package aiss.githubminer.transformer;

import aiss.githubminer.model.CommentGHM;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.model.GitMiner.Issue;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static aiss.githubminer.service.CommentService.getCommentsURL;

@Component
public class IssueTransformer {

    public static Issue transform(IssueGHM issueGHM) {
        Issue issue = new Issue();
        issue.setId(String.valueOf(issueGHM.getId()));
        issue.setTitle(issueGHM.getTitle());
        issue.setDescription(issueGHM.getBody());
        issue.setState(issueGHM.getState());
        issue.setCreatedAt(issueGHM.getCreatedAt());
        issue.setUpdatedAt(issueGHM.getUpdatedAt());
        issue.setClosedAt(String.valueOf(issueGHM.getClosedAt()));
        issue.setAuthor(UserTransformer.transformer(issueGHM.getUser()));
        issue.setVotes(issueGHM.getComments());
        List<CommentGHM> comments = getCommentsURL(issueGHM.getCommentsUrl());
        issue.setComments(CommentTransformer.transformList(comments));
        if (issueGHM.getAssignee() != null) {
            issue.setAssignee(UserTransformer.transformer(issueGHM.getAssignee()));
        }
        return issue;
    }

    public static List<Issue> transformList(List<IssueGHM> issuesGHM) {
        return issuesGHM.stream()
                .map(IssueTransformer::transform)
                .collect(Collectors.toList());
    }
}
