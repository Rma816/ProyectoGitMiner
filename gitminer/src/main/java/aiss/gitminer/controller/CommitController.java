package aiss.gitminer.controller;

import aiss.gitminer.model.Commit;
import aiss.gitminer.repository.CommitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/commits")
public class CommitController {

    @Autowired
    CommitRepository commitRepository;

    /**
     * Función para obtener todos los Commits de GitMiner
     */

    @GetMapping
    public ResponseEntity<List<Commit>> findAll() {
        return ResponseEntity.ok(commitRepository.findAll());
    }

    /**
     * Función para obtener un Commit a partir de su id
     */

    @GetMapping("/{id}")
    public ResponseEntity<Commit> findById(@PathVariable String id) {
        return commitRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
