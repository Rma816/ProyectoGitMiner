package aiss.githubminer.service;

import aiss.githubminer.model.CommentGHM;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Value("${github.token}") // Con esto da error, si se pone directamente no
    private static String token;

    // Se extraen los comentarios de GitHubMiner

    public static List<CommentGHM> getAllComments(String owner, String repo, String issue) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/issues/" + issue + "/comments";
        return getCommentsURL(url);
    }

    // Función para obtener los comentarios a partir de una url

    public static List<CommentGHM> getCommentsURL(String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer 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");
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
