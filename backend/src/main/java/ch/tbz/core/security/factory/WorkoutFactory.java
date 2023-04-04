package ch.tbz.core.security.factory;

import ch.tbz.core.modl.blueprint.Blueprint;
import ch.tbz.core.modl.workout.Workout;

public class WorkoutFactory implements IWorkoutFactory{

    @Override
    public Workout create(Blueprint b) {
        Workout workout = new Workout(b, b.getUser());
        b.addGenerated(workout);
        return workout;
    }
}
