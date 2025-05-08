package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.BitBucketCommit;
import aiss.bitbucketminer.model.BitBucketIssue;
import aiss.bitbucketminer.model.containers.BitBucketCommitContainer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommitService {

    public static BitBucketCommitContainer getCommitFromUrl (String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, BitBucketCommitContainer.class);
    }
}
