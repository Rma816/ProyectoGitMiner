package aiss.githubminer.transformer;

import aiss.githubminer.model.CommitGHM;
import aiss.gitminer.model.Commit;

public class CommitTransformer {

    public static Commit transformerCommit(CommitGHM commitGHM) {

        if (commitGHM == null) {
           return null;
        }

        Commit commit = new Commit();
        commit.setId(commitGHM.getSha());
        // commit.setAuthoredDate(commitGHM.getAuthor() != null ? commitGHM.getAuthor().getDate() : null);
        // commit.setAuthorEmail(commitGHM.getAuthor() != null ? commitGHM.getAuthor().getEmail() : null)
        return null; //TODO: completar
    }
}
