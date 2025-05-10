package aiss.bitbucketminer.etl;

import aiss.bitbucketminer.model.BitBucketCommit;
import aiss.bitbucketminer.model.dependencies.Pair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommitTransformer {

    public static Commit transformCommit (BitBucketCommit commit) {
        Commit newCommit = new Commit();
        newCommit.setId(commit.getId());
        newCommit.setTitle(commit.getMessage());
        String author = (commit.getAuthor() != null && commit.getAuthor().getRaw() != null) ? commit.getAuthor().getRaw() : "Autor no disponible";
        Pair<String, String> nameAndEmail = parserContact(author);
        newCommit.setAuthorName(nameAndEmail.getFirst());
        newCommit.setAuthorEmail(nameAndEmail.getSecond());
        newCommit.setAuthoredDate(commit.getAuthored_date());
        newCommit.setMessage(commit.getMessage());
        newCommit.setWebUrl(commit.getWeb_url());
        return newCommit;
    }

    public static Pair<String, String> parserContact(String input) {
        if (input == null || !input.contains("<")) {
            return new Pair<>("Desconocido", "Sin correo");
        }

        Pattern pattern = Pattern.compile("^(.*)\\s+<(.+@.+)>$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String name = matcher.group(1).trim();
            String email = matcher.group(2).trim();
            return new Pair<>(name, email);
        } else {
            throw new IllegalArgumentException("Formato inválido: " + input);
        }
    }

}
