package org.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.models.AnswerRequest;
import java.util.function.ToDoubleBiFunction;

/**
 * RestController pre validáciu odpovedí.
 * Obsahuje endpoint na overenie správnosti odpovede.
 */
@RestController
@RequestMapping("/api")
public class ValidateController {

    /**
     * Overí, či je odpoveď správna.
     *
     * @param request Požiadavka obsahujúca odpoveď na validáciu.
     * @return ResponseEntity so správou o správnostu odpovede.
     */
    @PostMapping("/validate")
    public ResponseEntity<String> validateAnswer(@RequestBody AnswerRequest request) {
        TODO:
        if (request.getUserAnswer() == 42) {
            return ResponseEntity.ok("Correct answer!");
        } else {
            return ResponseEntity.ok("Wrong answer!");
        }
    }
}
