package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.BitBucketCommit;
import aiss.bitbucketminer.model.BitBucketIssue;
import aiss.bitbucketminer.model.BitBucketProject;
import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectTransformer {

    public static Project transformProject (BitBucketProject project, int nCommits, int nIssues, int maxPages) {
        Project newProject = new Project();
        newProject.setName(project.getName());
        newProject.setId(project.getId());
        // Limitar commits según nCommits y maxPages
        List<Commit> commits = project.getCommits().getCommits().stream()
                .limit((long) nCommits * maxPages)
                .map(CommitTransformer::transformCommit)
                .collect(Collectors.toList());
        newProject.setCommits(commits);
        // Limitar issues según nIssues y maxPages
        List<Issue> issues = project.getIssues().getIssues().stream()
                .limit((long) nIssues * maxPages)
                .map(IssueTransformer::transformIssue)
                .collect(Collectors.toList());
        newProject.setIssues(issues);
        newProject.setWebUrl(project.getWeb_url());
        return newProject;
    }
}
