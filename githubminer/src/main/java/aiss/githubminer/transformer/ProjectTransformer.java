package aiss.githubminer.transformer;

import aiss.githubminer.model.CommitGHM;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.model.ProjectGHM;
import aiss.githubminer.service.CommitService;
import aiss.githubminer.service.IssueService;
import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectTransformer {

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueTransformer issueTransformer;

    public Project transform(ProjectGHM projectGHM, Integer sinceCommits, Integer sinceIssues, Integer maxPages) {
        Project project = new Project();
        project.setId(projectGHM.getId() != null ? projectGHM.getId().toString() : null);
        project.setName(projectGHM.getName() != null ? projectGHM.getName() : "No Name");
        project.setWebUrl(projectGHM.getUrl() != null ? projectGHM.getUrl() : "No Web Url");

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime commitThreshold = LocalDateTime.now().minusDays(sinceCommits);

        List<CommitGHM> commitGHMs = CommitService.getCommitsURL(projectGHM.getCommitsUrl(), maxPages);
        List<Commit> commits = CommitTransformer.transformList(commitGHMs).stream()
                .filter(c -> {
                    try {
                        LocalDateTime date = LocalDateTime.parse(c.getAuthoredDate(), formatter);
                        return date.isAfter(commitThreshold);
                    } catch (DateTimeParseException e) {
                        System.err.println("Error parseando fecha de commit: " + c.getAuthoredDate());
                        return false;
                    }
                })
                .collect(Collectors.toList());
        project.setCommits(commits);

        LocalDateTime issueThreshold = LocalDateTime.now().minusDays(sinceIssues);
        List<IssueGHM> issuesGHMs = issueService.getIssuesURL(projectGHM.getIssuesUrl(), maxPages);
        List<Issue> issues = issueTransformer.transformList(issuesGHMs).stream()
                .filter(i -> {
                    try {
                        LocalDateTime date = LocalDateTime.parse(i.getUpdatedAt(), formatter);
                        return date.isAfter(issueThreshold);
                    } catch (DateTimeParseException e) {
                        System.err.println("Error parseando fecha de issue: " + i.getUpdatedAt());
                        return false;
                    }
                })
                .collect(Collectors.toList());
        project.setIssues(issues);

        return project;
    }
}
