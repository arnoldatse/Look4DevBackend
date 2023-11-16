package com.arnoldatse.look4dev.core.userProfile;

import com.arnoldatse.look4dev.core.entities.userProfile.UserProfileSimple;

import java.util.List;

public interface UserProfileRepository {
    public UserProfileSimple findById(int id);

    public List<UserProfileSimple> findAllById(int[] ids);
}
