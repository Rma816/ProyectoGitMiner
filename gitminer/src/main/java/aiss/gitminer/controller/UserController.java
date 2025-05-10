package aiss.gitminer.controller;

import aiss.gitminer.model.User;
import aiss.gitminer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * Función para obtener todos los Users de GitMiner
     */

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    /**
     * Función para obtener un User a partir de su id
     */

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
