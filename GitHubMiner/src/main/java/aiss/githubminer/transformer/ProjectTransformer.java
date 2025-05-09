package aiss.githubminer.transformer;

import aiss.githubminer.model.CommitGHM;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.model.ProjectGHM;
import aiss.githubminer.service.CommitService;
import aiss.githubminer.model.GitMiner.*;
import aiss.githubminer.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectTransformer {

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueTransformer issueTransformer;


    public Project transform(ProjectGHM projectGHM, Integer sinceCommitsDays, Integer sinceIssuesDays, Integer maxPages) {
        Project project = new Project();
        project.setId(String.valueOf(projectGHM.getId()));
        project.setName(projectGHM.getName());
        project.setWebUrl(projectGHM.getUrl());

        // Fecha límite para commits e issues
        LocalDateTime commitLimitDate = LocalDateTime.now().minusDays(sinceCommitsDays);
        LocalDateTime issueLimitDate = LocalDateTime.now().minusDays(sinceIssuesDays);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

        // Obtener y filtrar commits por fecha
        List<CommitGHM> commitGHMs = CommitService.getCommitsURL(projectGHM.getCommitsUrl(), maxPages);
        List<Commit> commits = CommitTransformer.transformList(commitGHMs).stream()
                .filter(c -> {
                    try {
                        if (c.getAuthoredDate() == null) return false;
                        ZonedDateTime authoredDate = ZonedDateTime.parse(c.getAuthoredDate(), formatter);
                        return OffsetDateTime.parse(c.getAuthoredDate()).toLocalDateTime().isAfter(commitLimitDate);
                    } catch (Exception e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        project.setCommits(commits);

        // Obtener y filtrar issues por fecha
        List<IssueGHM> issuesGHMs = issueService.getIssuesURL(projectGHM.getIssuesUrl(), maxPages);
        List<Issue> issues = issueTransformer.transformList(issuesGHMs).stream()
                .filter(i -> {
                    try {
                        if (i.getUpdatedAt() == null) return false;
                        ZonedDateTime updatedAt = ZonedDateTime.parse(i.getUpdatedAt(), formatter);
                        return OffsetDateTime.parse(i.getUpdatedAt()).toLocalDateTime().isAfter(issueLimitDate);
                    } catch (Exception e) {
                        return false; // Si hay un error en la conversión, lo ignoramos
                    }
                })
                .collect(Collectors.toList());

        project.setIssues(issues);

        return project;
    }

}
