package dev.arnoldatse.opensource.look4dev.core.security;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AuthorisationManager {
    private final List<UserProfileName> requiredUserProfilesNames;
    protected final List<UserProfileName> userProfilesNames;

    protected AuthorisationManager(List<UserProfileName> requiredUserProfilesNames, List<UserProfileName> userProfilesNames) {
        this.requiredUserProfilesNames = requiredUserProfilesNames;
        this.userProfilesNames = userProfilesNames;
    }

    protected void checkUserAuthorized() throws ForbiddenException {
        boolean isUserAuthorized = userProfilesNames.stream()
                .anyMatch(requiredUserProfilesNames::contains);

        if (!isUserAuthorized) {
            throw new ForbiddenException("User is not authorized to perform this action");
        }
    }
}
