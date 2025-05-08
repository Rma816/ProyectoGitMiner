package aiss.githubminer.service;

import aiss.githubminer.model.CommentGHM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    public List<CommentGHM> getAllComments(String owner, String repo, String issue) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/issues/" + issue + "/comments";
        CommentGHM[] response = restTemplate.getForObject(url, CommentGHM[].class);
        if (response != null) {
            return List.of(response);
        } else {
            return null;
        }
    }

}
