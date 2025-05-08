package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.containers.BitBucketCommentContainer;
import org.springframework.web.client.RestTemplate;


public class CommentService {

    public static BitBucketCommentContainer obtenerCommentDesdeUrl (String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, BitBucketCommentContainer.class);
    }
}
