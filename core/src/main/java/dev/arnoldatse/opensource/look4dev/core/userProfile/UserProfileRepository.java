package dev.arnoldatse.opensource.look4dev.core.userProfile;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;

import java.util.List;

public interface UserProfileRepository {
    public UserProfile findById(int id);

    public List<UserProfile> findAllById(int[] ids);
}
