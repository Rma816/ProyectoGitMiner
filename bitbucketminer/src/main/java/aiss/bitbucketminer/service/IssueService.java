package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.BitBucketCommit;
import aiss.bitbucketminer.model.BitBucketIssue;
import aiss.bitbucketminer.model.containers.BitBucketIssueContainer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IssueService {

    public static BitBucketIssueContainer getIssuesFromUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, BitBucketIssueContainer.class);

    }
}
