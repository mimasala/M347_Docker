package ch.tbz.core.security.factory;

import ch.tbz.core.modl.blueprint.Blueprint;
import ch.tbz.core.modl.user.User;

public interface IBluepruntFactory {
    Blueprint create(User u);
}
