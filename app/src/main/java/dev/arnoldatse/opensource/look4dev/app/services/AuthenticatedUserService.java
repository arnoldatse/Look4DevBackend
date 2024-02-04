package dev.arnoldatse.opensource.look4dev.app.services;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticatedUserService {
    public User getAuthenticatedUser() {
        User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return authenticatedUser.clone();
    }

    public List<UserProfileName> getAuthenticatedUserProfiles(){
        String authorityPrefix = "ROLE_";
        List<UserProfileName> userProfileNames = new ArrayList<>();
        GrantedAuthority[] simpleGrantedAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray(new GrantedAuthority[0]);
        for (GrantedAuthority simpleGrantedAuthority : simpleGrantedAuthorities) {
            if (simpleGrantedAuthority.getAuthority().equals(authorityPrefix+UserProfileName.DEVELOPER.getValue())) {
                userProfileNames.add(UserProfileName.DEVELOPER);
            }
            if (simpleGrantedAuthority.getAuthority().equals(authorityPrefix+UserProfileName.RECRUITER.getValue())) {
                userProfileNames.add(UserProfileName.RECRUITER);
            }
        }
        return userProfileNames;
    }
}
