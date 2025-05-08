package aiss.githubminer.transformer;

import aiss.githubminer.model.CommentGHM;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.model.GitMiner.Issue;
import aiss.githubminer.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

public class IssueTransformer {

    //TODO: revisar issues y project

    public static Issue transform(IssueGHM issueGHM) {
        Issue issue = new Issue();
        issue.setId(issueGHM.getId());
        issue.setTitle(issueGHM.getTitle());
        issue.setDescription(issueGHM.getBody());
        issue.setState(issueGHM.getState());
        issue.setCreatedAt(issueGHM.getCreatedAt());
        issue.setUpdatedAt(issueGHM.getUpdatedAt());
        issue.setClosedAt(issueGHM.getClosedAt());
        issue.setAuthor(UserTransformer.transformer(issueGHM.getUser()));
        issue.setVotes(issueGHM.getComments());
        List<CommentGHM> comments = CommentService.getCommentsByURL(issueGHM.getCommentsUrl());
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
