package dev.arnoldatse.opensource.look4dev.core.userSkills.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.security.AuthorisationManager;

import java.util.List;

public abstract class UserSkillsUseCases extends AuthorisationManager {
    protected UserSkillsUseCases(List<UserProfileName> userProfilesNames) {
        super(List.of(UserProfileName.DEVELOPER), userProfilesNames);
    }

    protected void checkUserSkillsActionsAuthorized() throws ForbiddenException {
        try {
            checkUserAuthorized();
        } catch (ForbiddenException e) {
            throw new ForbiddenException("User have not DEVELOPER profile");
        }
    }
}
