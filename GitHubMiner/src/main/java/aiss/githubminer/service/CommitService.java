package aiss.githubminer.service;

import aiss.githubminer.model.CommitGHM;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CommitService {

    public static List<CommitGHM> getCommits(String commitsUrl) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CommitGHM[] commits = restTemplate.getForObject(commitsUrl, CommitGHM[].class);
            return Arrays.asList(commits != null ? commits : new CommitGHM[0]);
        } catch (Exception e) {
            System.err.println("Error al obtener commits: " + e.getMessage());
            return Collections.emptyList();
        }
    }

//    @Autowired
//    private CommitRepository commitRepository;
//
//    public List<Commit> getAllCommits() {
//        return commitRepository.findAll();
//    }
//
//    public Optional<Commit> getCommitById(String id) {
//        return commitRepository.findById(id);
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
}
