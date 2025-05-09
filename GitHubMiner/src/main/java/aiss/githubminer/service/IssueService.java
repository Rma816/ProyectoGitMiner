package aiss.githubminer.service;

import aiss.githubminer.model.GitMiner.Issue;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.transformer.IssueTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    private static RestTemplate restTemplate;

    @Autowired
    public IssueService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${github.token}")
    private String token;

    public List<IssueGHM> getIssues(String owner, String repo) {
        String url = String.format("https://api.github.com/repos/%s/%s/issues", owner, repo);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<IssueGHM[]> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, IssueGHM[].class);

        return Arrays.asList(response.getBody());
    }

    public static List<IssueGHM> getIssuesURL(String issuesUrl) {
        try {
            IssueGHM[] issues = restTemplate.getForObject(issuesUrl, IssueGHM[].class);
            return Arrays.asList(issues != null ? issues : new IssueGHM[0]);
        } catch (Exception e) {
            System.err.println("Error al obtener issues: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Issue> mapIssues(List<IssueGHM> issues) {
        return issues.stream().map(IssueTransformer::transform).collect(Collectors.toList());
    }
}