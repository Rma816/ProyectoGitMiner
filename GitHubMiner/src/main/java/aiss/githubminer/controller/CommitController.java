package aiss.githubminer.controller;

import aiss.githubminer.model.CommitGHM;
import aiss.githubminer.service.CommitService;
import aiss.githubminer.service.IssueService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commits")
public class CommitController {

    @Autowired
    private CommitService commitService;

    @GetMapping("/github/{owner}/{repo}")
    public ResponseEntity<List<CommitGHM>> getAllCommitsGHM(@PathVariable String owner,
                                                            @PathVariable String repo) {
        List<CommitGHM> commits = commitService.getAllCommits(owner, repo);
        return ResponseEntity.ok(commits);
    }
}

//    public Optional<CommitGHM> getCommitById(String id) {
//        return commitService.findById(id);
//    }
//
//    public List<Commit> saveCommits(List<Commit> commits) {
//        return commitRepository.saveAll(commits);
//    }
//
//    public Commit saveCommit(Commit commit) {
//        return commitRepository.save(commit);
//    }
//
//    public void deleteCommitById(String id) {
//        commitRepository.deleteById(id);
//    }

