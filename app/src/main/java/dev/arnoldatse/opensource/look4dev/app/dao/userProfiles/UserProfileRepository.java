package dev.arnoldatse.opensource.look4dev.app.dao.userProfiles;

import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {
}
