package aiss.githubminer.transformer;

import aiss.githubminer.model.CommentGHM;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.model.GitMiner.Issue;
import aiss.githubminer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssueTransformer {

    @Autowired
    private CommentService commentService;

    public Issue transform(IssueGHM issueGHM) {
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
        List<CommentGHM> comments = commentService.getCommentsURL(issueGHM.getCommentsUrl());
        issue.setComments(CommentTransformer.transformList(comments));
        if (issueGHM.getAssignee() != null) {
            issue.setAssignee(UserTransformer.transformer(issueGHM.getAssignee()));
        }
        return issue;
    }

    public List<Issue> transformList(List<IssueGHM> issuesGHM) {
        return issuesGHM.stream()
                .map(this::transform)
                .collect(Collectors.toList());
    }
}
