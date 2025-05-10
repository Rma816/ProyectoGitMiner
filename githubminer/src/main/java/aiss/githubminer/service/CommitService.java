package aiss.githubminer.service;

import aiss.githubminer.model.CommitGHM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CommitService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${github.token}")
    private String token;

    public List<CommitGHM> getAllCommits(String owner, String repo) {
        try {
            String uri = "https://api.github.com/repos/" + owner + "/" + repo + "/commits";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token);

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<CommitGHM[]> response = restTemplate.exchange(
                    uri, HttpMethod.GET, entity, CommitGHM[].class);

            return response.getBody() != null? Arrays.asList(response.getBody()): Collections.emptyList();
        } catch (Exception e) {
            System.err.println("Failed to obtain commits: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public static List<CommitGHM> getCommitsURL(String commitsUrl, Integer maxPages) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String cleanedUrl = commitsUrl.replace("{/sha}", "");

            HttpHeaders headers = new HttpHeaders();
            headers.add("User-Agent", "MyApp");
            headers.set("Authorization", "Bearer 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");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            List<CommitGHM> allCommits = new java.util.ArrayList<>();

            for (int page = 1; page <= maxPages; page++) {
                String paginatedUrl = cleanedUrl + "?per_page=100&page=" + page;

                ResponseEntity<CommitGHM[]> response = restTemplate.exchange(
                        paginatedUrl,
                        HttpMethod.GET,
                        entity,
                        CommitGHM[].class
                );

                CommitGHM[] commits = response.getBody();
                if (commits == null || commits.length == 0) {
                    break; // No hay más datos
                }

                allCommits.addAll(Arrays.asList(commits));
            }

            return allCommits;
        } catch (Exception e) {
            System.err.println("Failed to obtain commits: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}