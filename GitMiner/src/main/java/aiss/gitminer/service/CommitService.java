package aiss.gitminer.service;

import java.util.List;

import java.util.ArrayList;
import aiss.gitminer.model.Commit;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CommitService {
    List<Commit> commits = new ArrayList<>(); // List of imported Commit objects
    public List<Commit> getCommits() {
        return commits;
    }
    public Commit getCommit(String id) {
        return commits.stream()
                .filter(commit -> commit.getId().equals(id))
                .findFirst()
                .orElse(null); // o lanzar una excepción si no se encuentra el commit
    }
    public Commit createCommit(Commit commit) {
        commits.add(commit);
        return commit;
    }
    public void createCommits(List<Commit> commits) {
        this.commits.addAll(commits);
    }
}
