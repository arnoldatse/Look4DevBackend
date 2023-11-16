package com.arnoldatse.look4dev.details.database.springJPA.userProfiles;

import com.arnoldatse.look4dev.app.entities.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileJPARepository extends CrudRepository<UserProfile, Integer> {
}
