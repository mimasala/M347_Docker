package ch.tbz.controllers;

import ch.tbz.domain.exercise.Exercise;
import ch.tbz.domain.exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/WorkoutController")
public class WorkoutController {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public WorkoutController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("/getExercises")
    public List<Exercise> getWorkouts() {
        return exerciseRepository.findAll();
    }

}
