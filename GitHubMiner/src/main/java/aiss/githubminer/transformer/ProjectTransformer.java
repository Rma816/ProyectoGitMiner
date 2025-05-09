package aiss.githubminer.transformer;

import aiss.githubminer.model.CommitGHM;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.model.ProjectGHM;
import aiss.githubminer.service.CommitService;
import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;
import aiss.githubminer.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectTransformer {

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueTransformer issueTransformer;

    public Project transform(ProjectGHM projectGHM) {
        Project project = new Project();
        project.setId(String.valueOf(projectGHM.getId()));
        project.setName(projectGHM.getName());
        project.setWebUrl(projectGHM.getUrl());

        // Se obtienen los commits de la url en formato de GitHubMiner,
        // luego se transforman a los de GitMiner
        List<CommitGHM> commitGHMs = CommitService.getCommitsURL(projectGHM.getCommitsUrl());
        List<Commit> commits = CommitTransformer.transformList(commitGHMs);
        project.setCommits(commits);

        // Se obtienen los issues de la url en formato de GitHubMiner,
        // luego se transforman a los de GitMiner
        List<IssueGHM> issuesGHMs = issueService.getIssuesURL(projectGHM.getIssuesUrl());
        List<Issue> issues = issueTransformer.transformList(issuesGHMs);
        project.setIssues(issues);
        return project;
    }
}
