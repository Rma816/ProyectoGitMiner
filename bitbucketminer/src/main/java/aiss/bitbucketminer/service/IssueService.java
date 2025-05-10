package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.containers.BitBucketIssueContainer;
import org.springframework.web.client.RestTemplate;

public class IssueService {

    public static BitBucketIssueContainer getIssuesFromUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, BitBucketIssueContainer.class);

    }
}
