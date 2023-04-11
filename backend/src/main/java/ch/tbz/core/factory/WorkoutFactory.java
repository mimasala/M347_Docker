package ch.tbz.core.factory;

import ch.tbz.domain.blueprint.Blueprint;
import ch.tbz.domain.blueprint.ExerciseType;
import ch.tbz.domain.exercise.ExcerciseRepository;
import ch.tbz.domain.exercise.Exercise;
import ch.tbz.domain.set.Set;
import ch.tbz.domain.workout.Rating;
import ch.tbz.domain.workout.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WorkoutFactory implements IWorkoutFactory{

    private final ExcerciseRepository exerciseRepo;

    @Autowired
    public WorkoutFactory(ExcerciseRepository exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    @Override
    public Workout create(Blueprint b) {
        Workout workout = Workout.builder()
                .user(b.getUser())
                .sets(GenerateSets(GetExercisesByType(b.getTypes()), b))
                .build();
        b.addGenerated(workout);
        return workout;
    }

    private List<Set> GenerateSets(List<Exercise> exercises, Blueprint blueprint){
        List<Set> sets = new ArrayList<>();
        List<Workout> generated = blueprint.getGenerated();
        Workout previousWorkout = generated.get(generated.size() - 1);
        for (Exercise exercise:
             exercises) {
            sets.add(GenerateSet(exercise, blueprint, previousWorkout));
        }

        return sets;
    }

    private Set GenerateSet(Exercise e, Blueprint blueprint, Workout previous){
        Rating rating = previous.getRating();
        //TODO: Go **** yourself
    }

    private List<Exercise> GetExercisesByType(List<ExerciseType> types){
        List<Exercise> exercises = new ArrayList<>();
        for (ExerciseType t :
                types) {
            Optional<Exercise> hit = exerciseRepo
                    .GetExercisesByType(t.getDifficulty(), t.getEquipment(), t.getType(), t.getMuscle())
                    .stream().findFirst();
            if (hit.isEmpty()){
                continue;
            }
            exercises.add(hit.get());
        }
        return exercises;
    }
}
