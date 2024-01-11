package dev.arnoldatse.opensource.look4dev.app.dao.userUserProfile;

import dev.arnoldatse.opensource.look4dev.app.entities.UserUserProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserUserProfileRepository extends CrudRepository<UserUserProfile, String> {
    List<UserUserProfile> findByUserId(String id);
}
