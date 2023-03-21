package ch.tbz.factory;

import ch.tbz.modl.blueprint.Blueprint;
import ch.tbz.modl.user.User;

public interface IBluepruntFactory {
    Blueprint create(User u);
}
