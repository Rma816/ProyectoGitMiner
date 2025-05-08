package aiss.githubminer.service;

import aiss.githubminer.model.CommitGHM;
import aiss.githubminer.model.GitMiner.Commit;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.transformer.CommitTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommitService {

    @Autowired
    RestTemplate restTemplate;

    public List<CommitGHM> getAllCommits(String owner, String repo) {
        List<CommitGHM> commits = null;
        String uri = "https://api.github.com/repos/" + owner + "/" + repo + "/commits";
        CommitGHM[] arrayCommits = restTemplate.getForObject(uri, CommitGHM[].class);
        return Arrays.asList(arrayCommits);
    }

    public static List<CommitGHM> getCommitsURL(String commitsUrl) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            CommitGHM[] commits = restTemplate.getForObject(commitsUrl, CommitGHM[].class);
            return Arrays.asList(commits != null ? commits : new CommitGHM[0]);
        } catch (Exception e) {
            System.err.println("Error al obtener issues: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public CommitGHM getCommitByRef(String author, String repo, String ref) {
        CommitGHM commit = null;
        String uri = "https://api.github.com/repos/" + author + "/" + repo + "/commits/" + ref;
        commit = restTemplate.getForObject(uri, CommitGHM.class);
        return commit;
    }

    public List<Commit> mapCommits(List<CommitGHM> commits) {
        return commits.stream().map(CommitTransformer::transform).collect(Collectors.toList());
    }
}