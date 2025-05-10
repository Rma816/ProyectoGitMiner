package aiss.gitminer.controller;

import aiss.gitminer.service.UserService;
import aiss.gitminer.model.User;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gitminer/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userRepository) {
        this.userService = userRepository;
    }
    /**
     * Obtiene todos los usuarios de gitminer
     */
    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }
    /**
     * Obtiene un usuario específico desde Gitminer.
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok(user);
    }
}
