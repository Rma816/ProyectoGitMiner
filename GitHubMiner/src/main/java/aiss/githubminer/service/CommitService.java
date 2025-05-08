package aiss.githubminer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommitService {

    @Autowired
    RestTemplate restTemplate;

    public List<Commit> getAllCommits(String owner, string repo) {
        List<Commit> commits = null;
        String uri = "https://api.github.com/repos/" + owner + "/" + repo + "/commits";
        Commit[] arrayCommits = restTemplate.getForObject(uri, Commit[].class);
        return Arrays.asList(arrayCommits);
    }

    public Commit getCommitByRef(String author, string repo, string ref) {
        Commit commit = null;
        String uri = "https://api.github.com/repos/" + owner + "/" + repo + "/commits/" + ref;
        commit = restTemplate.getForObject(uri, Commit.class);
        return commit;
    }
}