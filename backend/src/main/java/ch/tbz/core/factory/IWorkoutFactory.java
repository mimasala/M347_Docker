package ch.tbz.core.factory;

import ch.tbz.domain.blueprint.Blueprint;
import ch.tbz.domain.workout.Workout;

public interface IWorkoutFactory {
    Workout create(Blueprint b);
}
