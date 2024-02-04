package dev.arnoldatse.opensource.look4dev.core.security;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;

import java.util.HashSet;
import java.util.List;

public abstract class AuthorisationManager {
    private final List<UserProfileName> requiredUserProfilesNames;
    private final List<UserProfileName> userProfilesNames;

    protected AuthorisationManager(List<UserProfileName> requiredUserProfilesNames, List<UserProfileName> userProfilesNames) {
        this.requiredUserProfilesNames = requiredUserProfilesNames;
        this.userProfilesNames = userProfilesNames;
    }

    protected void checkUserAuthorized() throws ForbiddenException {
        if (!new HashSet<>(userProfilesNames).containsAll(requiredUserProfilesNames)) {
            throw new ForbiddenException("User is not authorized to perform this action");
        }
    }
}
