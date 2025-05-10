package aiss.gitminer.service;

import java.util.List;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Comment;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    List<Issue> issues = new ArrayList<>(); // List of imported Issue objects
    List<Comment> comments = new ArrayList<>(); // List of imported Comment objects
    public List<Issue> getIssues() {
        return issues;
    }
    public Issue getIssue(String id) {
        return issues.stream()
                .filter(issue -> issue.getId().equals(id))
                .findFirst()
                .orElse(null); // o lanzar una excepción si no se encuentra el issue
    }
    public List<Comment> getIssueComments(String id) {
        Issue issue = getIssue(id);
        if (issue != null) {
            return issue.getComments();
        }
        return null; // o lanzar una excepción si no se encuentra el issue
    }
    public List<Issue> getIssuesByUser(String userId) {
        return issues.stream()
                .filter(issue -> issue.getAuthor().getId().equals(userId))
                .toList(); // o lanzar una excepción si no se encuentra el issue
    }
    public List<Issue> getIssuesByState(String state) {
        return issues.stream()
                .filter(issue -> issue.getState().equals(state))
                .toList(); // o lanzar una excepción si no se encuentra el issue
    }
    public Issue createIssue(Issue issue) {
        issues.add(issue);
        return issue;
    }
    public List<Issue> createIssues(List<Issue> issues) {
        this.issues.addAll(issues);
        return issues;
    }
}
