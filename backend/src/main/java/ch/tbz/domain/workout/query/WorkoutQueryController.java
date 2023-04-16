package ch.tbz.domain.workout.query;

import ch.tbz.domain.workout.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutQueryController {
    WorkoutQueryService workoutQueryService;

    @Autowired
    public WorkoutQueryController(WorkoutQueryService workoutQueryService) {
        this.workoutQueryService = workoutQueryService;
    }

    @GetMapping()
    public ResponseEntity<Page<Workout>> getAllWorkouts(@RequestParam Integer page,
                                                       @RequestParam Integer size) {
        Page<Workout> workouts = workoutQueryService.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok(workouts);
    }
}
