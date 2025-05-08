package aiss.githubminer.service;

import aiss.githubminer.model.CommentGHM;
import aiss.githubminer.model.GitMiner.Comment;
import aiss.githubminer.transformer.CommentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Se extraen los comentarios de GitHubMiner

    public List<CommentGHM> getAllComments(String owner, String repo, String issue) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/issues/" + issue + "/comments";
        CommentGHM[] response = restTemplate.getForObject(url, CommentGHM[].class);
        if (response != null) {
            return List.of(response);
        } else {
            return null;
        }
    }

    // Se transforman al formato Comment de GitMiner

    public List<Comment> mapComments(List<CommentGHM> comments) {
        return comments
                .stream().map(CommentTransformer::transform)
                .collect(Collectors.toList());
    }

    // Obtener comentarios a partir de una URL

    public static List<CommentGHM> getCommentsByURL(String url) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            CommentGHM[] comments = restTemplate.getForObject(url, CommentGHM[].class);
            return Arrays.asList(comments != null ? comments : new CommentGHM[0]);
        } catch (Exception e) {
            System.err.println("Error al obtener issues: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
