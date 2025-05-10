package aiss.githubminer.service;

import aiss.githubminer.model.IssueGHM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${github.token}")
    private String token;

    public List<IssueGHM> getIssues(String owner, String repo) {
        String url = String.format("https://api.github.com/repos/%s/%s/issues", owner, repo);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<IssueGHM[]> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, IssueGHM[].class);

        return Arrays.asList(response.getBody());
    }

    public List<IssueGHM> getIssuesURL(String issuesUrl, Integer maxPages) {
        RestTemplate restTemplate = new RestTemplate();
        String cleanedUrl = issuesUrl.replace("{/number}", "");

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "MyApp");
        headers.set("Authorization", "Bearer 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");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        List<IssueGHM> allIssues = new ArrayList<>();

        try {
            for (int page = 1; page <= maxPages; page++) {
                String paginatedUrl = cleanedUrl + "?per_page=100&page=" + page;

                ResponseEntity<IssueGHM[]> response = restTemplate.exchange(
                        paginatedUrl,
                        HttpMethod.GET,
                        entity,
                        IssueGHM[].class
                );

                IssueGHM[] issues = response.getBody();
                if (issues == null || issues.length == 0) break;

                allIssues.addAll(Arrays.asList(issues));
            }

            return allIssues;
        } catch (Exception e) {
            System.err.println("Error al obtener issues: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
