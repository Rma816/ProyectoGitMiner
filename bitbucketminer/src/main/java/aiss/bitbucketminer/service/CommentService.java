package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.containers.BitBucketCommentContainer;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


public class CommentService {

    public static BitBucketCommentContainer obtenerCommentDesdeUrl (String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, BitBucketCommentContainer.class);
        } catch (Exception e) {
            System.err.println("Failed to obtain comments: " + e.getMessage());
            return null;
        }
    }
}
