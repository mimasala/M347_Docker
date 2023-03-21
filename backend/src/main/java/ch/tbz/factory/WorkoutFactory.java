package ch.tbz.factory;

import ch.tbz.modl.blueprint.Blueprint;
import ch.tbz.modl.workout.Workout;

public class WorkoutFactory implements IWorkoutFactory{

    @Override
    public Workout create(Blueprint b) {
        Workout workout = new Workout(b, b.getUser());
        b.addGenerated(workout);
        return workout;
    }
}
