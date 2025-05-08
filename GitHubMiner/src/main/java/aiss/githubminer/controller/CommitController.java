package aiss.githubminer.controller;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommitService {

    @Autowired
   private CommitRepository commitRepository;

    public List<Commit> getAllCommits() {
        return commitRepository.findAll();
    }

    public Optional<Commit> getCommitById(String id) {
        return commitRepository.findById(id);
    }

    public List<Commit> saveCommits(List<Commit> commits) {
        return commitRepository.saveAll(commits);
    }

    public Commit saveCommit(Commit commit) {
        return commitRepository.save(commit);
    }

    public void deleteCommitById(String id) {
        commitRepository.deleteById(id);
    }
}
