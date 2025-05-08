package aiss.githubminer.service;

import aiss.githubminer.model.CommentGHM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Test
    @DisplayName("Get all comments for a GitHub issue - 1")
    void getAllComments() {
        // Datos de entrada
        String owner = "octocat";
        String repo = "Hello-World";
        String issue = "1";

        // Ejecución
        List<CommentGHM> comments = commentService.getAllComments(owner, repo, issue);

        // Aserciones
        assertNotNull(comments, "La lista de comentarios no debería ser nula");
        assertTrue(comments.size() > 0, "La lista debería contener al menos un comentario");

        // Imprimir resultados para verificar
        comments.forEach(comment -> System.out.println("Comentario ID: " + comment.getId() + ", Cuerpo: " + comment.getBody()));
    }
}