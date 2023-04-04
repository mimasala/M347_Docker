package ch.tbz.core.helpers;

import ch.tbz.core.modl.user.User;

import java.security.Principal;

public class UserConverter {
    public static User convert(Principal p){
        return (User) p;
    }
}
