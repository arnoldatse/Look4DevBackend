package dev.arnoldatse.opensource.look4dev.app.security.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.mappers.MapperFromUserProfile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class MapperUserProfileToSimpleGrantedAuthority implements MapperFromUserProfile<SimpleGrantedAuthority> {
    private final UserProfile userProfile;

    public MapperUserProfileToSimpleGrantedAuthority(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public SimpleGrantedAuthority mapFromUserProfile() {
        return new SimpleGrantedAuthority("ROLE_"+userProfile.getName().getValue());
    }
}
