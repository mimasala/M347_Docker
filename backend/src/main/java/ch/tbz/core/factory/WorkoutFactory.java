package ch.tbz.core.factory;

import ch.tbz.domain.blueprint.Blueprint;
import ch.tbz.domain.blueprint.ExerciseType;
import ch.tbz.domain.exercise.Exercise;
import ch.tbz.domain.exercise.ExerciseRepo;
import ch.tbz.domain.workout.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkoutFactory implements IWorkoutFactory{

    private final ExerciseRepo exerciseRepo;

    @Autowired
    public WorkoutFactory(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    @Override
    public Workout create(Blueprint b) {
        Workout workout = Workout.builder()
                        .user(b.getUser())
        b.addGenerated(workout);
        return workout;
    }

    private List<Exercise> GetExercisesByType(ExerciseType t, int count){
        List<Exercise> exercises = exerciseRepo
                .GetExercisesByType(t.getDifficulty(), t.getEquipment(), t.getType(), t.getMuscle());
        if (exercises.size() <= count){
            return exercises;
        }
        return exercises.stream().limit(count).toList();
    }
}
