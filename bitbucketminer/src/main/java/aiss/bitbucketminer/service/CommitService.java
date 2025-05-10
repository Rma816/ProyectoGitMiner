package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.containers.BitBucketCommitContainer;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class CommitService {

    public static BitBucketCommitContainer getCommitFromUrl (String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, BitBucketCommitContainer.class);
        } catch (Exception e) {
            System.err.println("Failed to obtain commits: " + e.getMessage());
            return null;
        }
    }
}
