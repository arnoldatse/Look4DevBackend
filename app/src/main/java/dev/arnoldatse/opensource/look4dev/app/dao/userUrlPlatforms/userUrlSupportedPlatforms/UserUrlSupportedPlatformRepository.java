package dev.arnoldatse.opensource.look4dev.app.dao.userUrlPlatforms.userUrlSupportedPlatforms;

import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserUrlSupportedPlatformRepository extends CrudRepository<UserUrlSupportedPlatform, String> {
    List<UserUrlSupportedPlatform> findAllByUserId(String userId);

    @Modifying
    @Query("delete from UserUrlSupportedPlatform u where u.user.id = ?1")
    void deleteByUserId(String userId);
}
