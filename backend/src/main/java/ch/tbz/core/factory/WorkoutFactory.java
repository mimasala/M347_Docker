package ch.tbz.core.factory;

import ch.tbz.domain.blueprint.Blueprint;
import ch.tbz.domain.blueprint.ExerciseType;
import ch.tbz.domain.exercise.Exercise;
import ch.tbz.domain.exercise.ExerciseRepo;
import ch.tbz.domain.set.Set;
import ch.tbz.domain.workout.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
                .sets()
        b.addGenerated(workout);
        return workout;
    }

    private List<Set> GenerateSets(List<Exercise> exercises, Blueprint blueprint){
        List<Set> sets = new ArrayList<>();
        for (Exercise exercise:
             exercises) {
            sets.add(GenerateSet(exercise, blueprint));
        }

        return sets;
    }

    private Set GenerateSet(Exercise e, Blueprint blueprint){
        List<Workout> generated = blueprint.getGenerated();
        Workout w = generated.get(generated.size() - 1);

        //TODO: Calculate best amount of sets etc...
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
