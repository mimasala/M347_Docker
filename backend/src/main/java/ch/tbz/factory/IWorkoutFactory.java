package ch.tbz.factory;

import ch.tbz.modl.blueprint.Blueprint;
import ch.tbz.modl.workout.Workout;

public interface IWorkoutFactory {
    Workout create(Blueprint b);
}
