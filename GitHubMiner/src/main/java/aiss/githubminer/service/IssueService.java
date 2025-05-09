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

import java.util.Arrays;
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

    public List<IssueGHM> getIssuesURL(String issuesUrl) {
        String cleanedUrl = issuesUrl.replace("{/number}", "");

        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "MyApp");
        headers.set("Authorization", "Bearer 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");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<IssueGHM[]> response = restTemplate.exchange(
                cleanedUrl,
                HttpMethod.GET,
                entity,
                IssueGHM[].class
        );

        IssueGHM[] issues = response.getBody();
        return Arrays.asList(issues != null ? issues : new IssueGHM[0]);
    }
}
