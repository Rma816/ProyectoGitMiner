package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.BitBucketComment;
import aiss.bitbucketminer.model.containers.BitBucketCommentContainer;
import aiss.gitminer.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class CommentService {

    public static BitBucketCommentContainer obtenerCommentDesdeUrl (String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, BitBucketCommentContainer.class);
    }
}
