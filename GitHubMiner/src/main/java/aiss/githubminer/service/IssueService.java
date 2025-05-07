package aiss.githubminer.service;

import aiss.githubminer.model.IssueGHM;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IssueService {

    public static List<IssueGHM> getIssues(String issuesUrl) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            IssueGHM[] issues = restTemplate.getForObject(issuesUrl, IssueGHM[].class);
            return Arrays.asList(issues != null ? issues : new IssueGHM[0]);
        } catch (Exception e) {
            System.err.println("Error al obtener issues: " + e.getMessage());
            return Collections.emptyList();
        }
    }

}
