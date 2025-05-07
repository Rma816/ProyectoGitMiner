package aiss.githubminer.transformer;

import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.model.ProjectGHM;
import aiss.githubminer.service.CommitService;
import aiss.githubminer.service.IssueService;
import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;

import java.util.List;

public class ProjectTransformer {

    public static Project transform(ProjectGHM projectGHM) {
        Project project = new Project();
        project.setId(String.valueOf(projectGHM.getId()));
        project.setName(projectGHM.getName());
        project.setWebUrl(projectGHM.getUrl());
        List<Commit> commits = CommitTransformer.transform(CommitService.getCommits(projectGHM.getCommitsUrl()));
        project.setCommits(commits);
        List<Issue> issues = IssueTransformer.transform(IssueService.getIssues(projectGHM.getIssuesUrl()));
        project.setIssues(issues);
        return project;
    }
}
