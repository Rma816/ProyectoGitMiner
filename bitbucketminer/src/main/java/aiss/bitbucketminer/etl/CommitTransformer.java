package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.BitBucketCommit;
import aiss.bitbucketminer.model.dependencies.Pair;
import aiss.gitminer.model.Commit;


public class CommitTransformer {

    public static Commit transformCommit(BitBucketCommit commit) {
        Commit newCommit = new Commit();
        newCommit.setId(commit.getId());
        newCommit.setMessage(commit.getMessage());
        newCommit.setTitle(commit.getTitle());
        newCommit.setAuthorName(commit.getAuthor_name());
        newCommit.setAuthorEmail(commit.getAuthor_email());
        newCommit.setAuthoredDate(commit.getAuthored_date());
        newCommit.setWebUrl(commit.getWeb_url());
        return newCommit;
    }

    public static Pair<String, String> parserContact(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new Pair<>("", "");
        }
        // Dividir la cadena en partes usando el patrón " <"
        String[] parts = input.split(" <", 2);
        String name = parts[0].trim();
        String email = "";
        if (parts.length > 1) {
            // Eliminar el ">" final si existe
            email = parts[1].replace(">", "").trim();
        }
        return new Pair<>(name, email);
    }
}
