package ch.tbz.helpers;

import ch.tbz.modl.user.User;

import java.security.Principal;

public class UserConverter {
    public static User convert(Principal p){
        return (User) p;
    }
}
