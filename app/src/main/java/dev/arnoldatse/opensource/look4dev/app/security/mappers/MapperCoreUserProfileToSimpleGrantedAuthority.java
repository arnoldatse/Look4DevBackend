package dev.arnoldatse.opensource.look4dev.app.security.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperFromUserProfile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class MapperCoreUserProfileToSimpleGrantedAuthority implements MapperFromUserProfile<SimpleGrantedAuthority> {
    private final UserProfile userProfile;

    public MapperCoreUserProfileToSimpleGrantedAuthority(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public SimpleGrantedAuthority mapFromUserProfile() {
        return new SimpleGrantedAuthority("ROLE_"+userProfile.getName().getValue());
    }
}
