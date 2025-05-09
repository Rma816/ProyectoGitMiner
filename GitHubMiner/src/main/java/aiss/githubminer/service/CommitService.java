package aiss.githubminer.service;

import aiss.githubminer.model.CommitGHM;
import aiss.githubminer.model.GitMiner.Commit;
import aiss.githubminer.transformer.CommitTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
        String uri = "https://api.github.com/repos/" + owner + "/" + repo + "/commits";
        CommitGHM[] arrayCommits = restTemplate.getForObject(uri, CommitGHM[].class);
        return Arrays.asList(arrayCommits);
    }

    public static List<CommitGHM> getCommitsURL(String commitsUrl) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String cleanedUrl = commitsUrl.replace("{/sha}", "");

            HttpHeaders headers = new HttpHeaders();
            headers.add("User-Agent", "MyApp");
            headers.set("Authorization", "Bearer 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");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<CommitGHM[]> response = restTemplate.exchange(
                    cleanedUrl,
                    HttpMethod.GET,
                    entity,
                    CommitGHM[].class
            );

            CommitGHM[] commits = response.getBody();
            return Arrays.asList(commits != null ? commits : new CommitGHM[0]);
        } catch (Exception e) {
            System.err.println("Error al obtener commits: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}