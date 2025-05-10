package aiss.gitminer.controller;

import aiss.gitminer.model.Commit;
import aiss.gitminer.repository.CommitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/commits")
public class CommitController {

    private final CommitRepository commitRepository;

    public CommitController(CommitRepository commitRepository) {
        this.commitRepository = commitRepository;
    }

    @GetMapping
    public ResponseEntity<List<Commit>> findAll() {
        return ResponseEntity.ok(commitRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commit> findById(@PathVariable String id) {
        return commitRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
