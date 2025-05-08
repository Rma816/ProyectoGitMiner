package aiss.githubminer.service;

import aiss.githubminer.model.CommitGHM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

    public CommitGHM getCommitByRef(String author, String repo, String ref) {
        CommitGHM commit = null;
        String uri = "https://api.github.com/repos/" + author + "/" + repo + "/commits/" + ref;
        commit = restTemplate.getForObject(uri, CommitGHM.class);
        return commit;
    }
}