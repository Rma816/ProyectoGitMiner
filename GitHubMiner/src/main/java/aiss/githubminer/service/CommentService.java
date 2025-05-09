package aiss.githubminer.service;

import aiss.githubminer.model.CommentGHM;
import aiss.githubminer.model.GitMiner.Comment;
import aiss.githubminer.model.IssueGHM;
import aiss.githubminer.transformer.CommentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${github.token}")
    private String token;

    // Se extraen los comentarios de GitHubMiner

    public List<CommentGHM> getAllComments(String owner, String repo, String issue) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/issues/" + issue + "/comments";
        return getCommentsURL(url);
    }

    public List<CommentGHM> getCommentsURL(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("User-Agent", "GitMinerApp");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CommentGHM[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                CommentGHM[].class);
        CommentGHM[] comments = response.getBody();
        return Arrays.asList(comments != null ? comments : new CommentGHM[0]);
    }

}
