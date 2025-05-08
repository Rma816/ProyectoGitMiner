//package aiss.githubminer.transformer;
//
//import aiss.githubminer.model.IssueGHM;
//import aiss.gitminer.model.Issue;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class IssueTransformer {
//
//    public static Issue transform(IssueGHM issueGHM) {
//        Issue issue = new Issue();
//        issue.setId(issueGHM.getId());
//        issue.setTitle(issueGHM.getTitle());
//        issue.setDescription(issueGHM.getBody());
//        issue.setState(issueGHM.getState());
//        issue.setCreatedAt(issueGHM.getCreatedAt());
//        issue.setUpdatedAt(issueGHM.getUpdatedAt());
//        issue.setClosedAt(issueGHM.getClosedAt());
//        return issue;
//    }
//
//    public static List<Issue> transform(List<IssueGHM> issuesGHM) {
//        return issuesGHM.stream()
//                .map(IssueTransformer::transform)
//                .collect(Collectors.toList());
//    }
//}
