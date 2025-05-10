package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.BitBucketUser;
import org.springframework.web.client.RestTemplate;

public class UserService {
    public static BitBucketUser getUserFromUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, BitBucketUser.class);
    }
}
