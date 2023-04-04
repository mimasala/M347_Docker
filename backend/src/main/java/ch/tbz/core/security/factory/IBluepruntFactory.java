package ch.tbz.core.security.factory;

import ch.tbz.domain.blueprint.Blueprint;
import ch.tbz.domain.user.User;

public interface IBluepruntFactory {
    Blueprint create(User u);
}
