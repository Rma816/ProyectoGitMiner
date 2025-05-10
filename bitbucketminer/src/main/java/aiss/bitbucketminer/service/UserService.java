package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.BitBucketUser;
import org.springframework.web.client.RestTemplate;

public class UserService {
    public static BitBucketUser getUserFromUrl(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, BitBucketUser.class);
        } catch (Exception e) {
                System.err.println("Failed to obtain the user: " + e.getMessage());
                return null;
            }
        }
}
