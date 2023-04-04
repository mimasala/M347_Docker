package ch.tbz.core.security.factory;

import ch.tbz.core.modl.blueprint.Blueprint;
import ch.tbz.core.modl.workout.Workout;

public interface IWorkoutFactory {
    Workout create(Blueprint b);
}
