package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.containers.BitBucketIssueContainer;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class IssueService {

    public static BitBucketIssueContainer getIssuesFromUrl(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, BitBucketIssueContainer.class);
        } catch (Exception e) {
            System.err.println("Failed to obtain issues: " + e.getMessage());
            return null;
        }
    }
}
