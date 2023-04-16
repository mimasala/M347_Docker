package ch.tbz.core.factory;

import ch.tbz.domain.blueprint.Blueprint;
import ch.tbz.domain.blueprint.ExerciseType;
import ch.tbz.domain.exercise.Exercise;
import ch.tbz.domain.exercise.ExerciseRepository;
import ch.tbz.domain.set.Set;
import ch.tbz.domain.workout.Rating;
import ch.tbz.domain.workout.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class WorkoutFactory implements IWorkoutFactory{

    private final ExerciseRepository exerciseRepo;

    @Autowired
    public WorkoutFactory(ExerciseRepository exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    @Override
    public Workout create(Blueprint b) {
        Workout workout = Workout.builder()
                .user(b.getUser())
                .sets(generateSets(GetExercisesByType(b.getTypes()), b))
                .build();
        b.addGenerated(workout);
        return workout;
    }

    private List<Set> generateSets(List<Exercise> exercises, Blueprint blueprint){
        List<Set> sets = new ArrayList<>();
        List<Workout> generated = blueprint.getGenerated();
        Workout previousWorkout = generated.get(generated.size() - 1);
        for (Exercise exercise: exercises) {
            sets.add(generateSet(exercise, blueprint, previousWorkout));
        }

        return sets;
    }

    private Set generateSet(Exercise e, Blueprint blueprint, Workout previous){ // TODO: ich chegg bluepring immernonig
        Rating rating = previous.getRating();
        Set previousSet = getSetFromPreviousWorkout(previous, e);
        if (rating.equals(Rating.Easy)){
            return progressiveOverloadedSet(e, previousSet);
        }
        if (rating.equals(Rating.Medium)){
            return previousSet;
        }
        return deProgressiveOverloadedSet(e, previousSet);
    }

    private Set deProgressiveOverloadedSet(Exercise e, Set previousSet){
        return Set.builder()
                .setCount(previousSet.getSetCount())
                .weight(previousSet.getRepCount() == 12 ? previousSet.getWeight() + 2.5 : previousSet.getWeight())
                .repCount(previousSet.getRepCount() == 12 ? 8 : previousSet.getRepCount() + 2)
                .exercise(e)
                .build();
    }

    private Set progressiveOverloadedSet(Exercise e, Set previousSet){
        return Set.builder()
                .setCount(previousSet.getSetCount())
                .weight(previousSet.getRepCount() == 12 ? previousSet.getWeight() + 2.5 : previousSet.getWeight())
                .repCount(previousSet.getRepCount() == 12 ? 8 : previousSet.getRepCount() + 2)
                .exercise(e)
                .build();
    }

    private Set getSetFromPreviousWorkout(Workout previous, Exercise e){
        Optional<Set> set = previous
                .getSets()
                .stream()
                .filter(s -> s.getExercise().equals(e))
                .findFirst();
        return set.orElse(null);
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
