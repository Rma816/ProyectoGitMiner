package aiss.githubminer.controller;

import aiss.githubminer.model.CommentGHM;
import aiss.githubminer.model.GitMiner.Comment;
import aiss.githubminer.service.CommentService;
import aiss.githubminer.transformer.CommentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/github")
public class CommentController {

    @Autowired
    CommentService commentService;

    // GET uri ej: https://api.github.com/repos/octocat/Hello-World/issues/1/comments

    @GetMapping("/{owner}/{repo}/issues/{issueId}/comments")
    public ResponseEntity<List<Comment>> getCommentsGHM(@PathVariable String owner,
                                                        @PathVariable String repo,
                                                        @PathVariable String issueId) {
        List<CommentGHM> comments = commentService.getAllComments(owner, repo, issueId);
        List<Comment> commentsList = CommentTransformer.transformList(comments);
        return ResponseEntity.ok(commentsList);
    }
}
