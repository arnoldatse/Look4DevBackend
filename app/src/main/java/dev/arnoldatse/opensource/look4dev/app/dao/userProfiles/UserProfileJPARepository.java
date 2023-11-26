package dev.arnoldatse.opensource.look4dev.app.dao.userProfiles;

import dev.arnoldatse.opensource.look4dev.app.entities.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileJPARepository extends CrudRepository<UserProfile, Integer> {
}
