package ch.tbz.domain.workout.query;

import ch.tbz.domain.workout.Workout;
import ch.tbz.domain.workout.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WorkoutQueryService {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutQueryService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Page<Workout> findAll(PageRequest of) {
        return workoutRepository.findAll(of);
    }
}
