package aiss.githubminer.controller;

import aiss.githubminer.model.GitMiner.User;
import aiss.githubminer.model.UserGHM;
import aiss.githubminer.service.UserService;
import aiss.githubminer.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        UserGHM user = userService.getUser(username);
        User mapUser = UserTransformer.transformer(user);
        return ResponseEntity.ok(mapUser);
    }


}
