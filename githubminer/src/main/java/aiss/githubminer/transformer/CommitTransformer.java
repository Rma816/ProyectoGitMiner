package aiss.githubminer.transformer;

import aiss.githubminer.model.CommitGHM;
import aiss.gitminer.model.Commit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommitTransformer {

    public static Commit transform(CommitGHM commitGHM) {
        Commit commit = new Commit();
        commit.setId(commitGHM.getSha() != null ? commitGHM.getSha() : "No Id");
        commit.setTitle(commitGHM.getNodeId() != null ? commitGHM.getNodeId() : "No Title");
        commit.setMessage(commitGHM.getCommit().getMessage() != null ? commitGHM.getCommit().getMessage() : "No Message");
        commit.setWebUrl(commitGHM.getHtmlUrl() != null ? commitGHM.getHtmlUrl() : "No Web Url");

        if (commitGHM.getCommit().getAuthor() != null) {
            commit.setAuthorName(commitGHM.getCommit().getAuthor().getName());
            commit.setAuthorEmail(commitGHM.getCommit().getAuthor().getEmail());
            commit.setAuthoredDate(commitGHM.getCommit().getAuthor().getDate());
        }

        return commit;
    }

    public static List<Commit> transformList(List<CommitGHM> commitsGHM) {
        return !commitsGHM.isEmpty() ? commitsGHM.stream()
            .map(CommitTransformer::transform)
            .collect(Collectors.toList()) : new ArrayList<>();
    }

}
