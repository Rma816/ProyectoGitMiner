package aiss.githubminer.transformer;

import aiss.githubminer.model.ProjectGHM;
import aiss.githubminer.service.CommitService;
import aiss.githubminer.model.GitMiner.*;
import aiss.githubminer.service.IssueService;

import java.util.List;

public class ProjectTransformer {

    public static Project transform(ProjectGHM projectGHM) {
        Project project = new Project();
        project.setId(String.valueOf(projectGHM.getId()));
        project.setName(projectGHM.getName());
        project.setWebUrl(projectGHM.getUrl());
        List<Commit> commits = CommitTransformer
                .transformList(CommitService.getCommitsURL(projectGHM.getCommitsUrl()));
        project.setCommits(commits);
        List<Issue> issues = IssueTransformer.transformList(IssueService.getIssuesURL(projectGHM.getIssuesUrl()));
        project.setIssues(issues);
        return project;
    }
}
