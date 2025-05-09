package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.containers.BitBucketCommitContainer;
import org.springframework.web.client.RestTemplate;

public class CommitService {

    public static BitBucketCommitContainer getCommitFromUrl (String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, BitBucketCommitContainer.class);
    }
}
