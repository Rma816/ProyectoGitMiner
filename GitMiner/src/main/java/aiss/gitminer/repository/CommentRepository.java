package aiss.gitminer.repository;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository

public class CommentRepository {
    List<Comment> comments = new ArrayList<>();

    public CommentRepository(){
        comments.add(new Comment(
                UUID.randomUUID().toString(),
                "comentario de prueba",
                ,
                "09/05/2025",
                ""

        ));
    }
}
