package dev.arnoldatse.opensource.look4dev.core.userProfile;

import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository {
    Optional<UserProfile> findById(int id);

    List<UserProfile> findAllById(int[] ids);
}
