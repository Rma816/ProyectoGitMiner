package aiss.githubminer.transformer;

import aiss.githubminer.model.CommitGHM;
import aiss.gitminer.model.Commit;

import java.util.List;
import java.util.stream.Collectors;

public class CommitTransformer {

    public static Commit transform(CommitGHM commitGHM) {
        Commit commit = new Commit();
        commit.setId(commitGHM.getSha());
        commit.setTitle(commitGHM.getNodeId());
        commit.setMessage(commitGHM.getCommit().getMessage());
        if (commitGHM.getCommit().getAuthor() != null) {
            commit.setAuthorName(commitGHM.getCommit().getAuthor().getName());
            commit.setAuthorEmail(commitGHM.getCommit().getAuthor().getEmail());
            commit.setAuthoredDate(commitGHM.getCommit().getAuthor().getDate());
        }
        commit.setWebUrl(commitGHM.getHtmlUrl());
        return commit;
    }

    public static List<Commit> transformList(List<CommitGHM> commitsGHM) {
        return commitsGHM.stream()
            .map(CommitTransformer::transform)
            .collect(Collectors.toList());
    }

}
