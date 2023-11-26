package dev.arnoldatse.opensource.look4dev.core.userProfile;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileSimple;

import java.util.List;

public interface UserProfileRepository {
    public UserProfileSimple findById(int id);

    public List<UserProfileSimple> findAllById(int[] ids);
}
