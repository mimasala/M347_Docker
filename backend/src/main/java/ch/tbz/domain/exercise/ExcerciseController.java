package ch.tbz.domain.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExcerciseController {
    private final ExcerciseService excerciseService;

    @Autowired
    public ExcerciseController(ExcerciseService excerciseService) {
        this.excerciseService = excerciseService;
    }
    @GetMapping("/exercises")
    public ResponseEntity<List<Exercise>> getExercises() {
        return ResponseEntity.ok(excerciseService.getExercises());
    }
}
