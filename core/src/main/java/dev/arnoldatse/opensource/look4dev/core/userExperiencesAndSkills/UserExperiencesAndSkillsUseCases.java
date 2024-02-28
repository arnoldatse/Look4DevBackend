package dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.security.AuthorisationManager;

import java.util.List;

public abstract class UserExperiencesAndSkillsUseCases extends AuthorisationManager {
    protected UserExperiencesAndSkillsUseCases(List<UserProfileName> userProfilesNames) {
        super(List.of(UserProfileName.DEVELOPER), userProfilesNames);
    }

    protected void checkUserExperiencesAndSkillsActionsAuthorized() throws ForbiddenException {
        try {
            checkUserAuthorized();
        } catch (ForbiddenException e) {
            throw new ForbiddenException("User have not DEVELOPER profile");
        }
    }
}
