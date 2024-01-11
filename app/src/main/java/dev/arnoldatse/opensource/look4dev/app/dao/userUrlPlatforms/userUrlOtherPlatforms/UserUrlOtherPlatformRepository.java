package dev.arnoldatse.opensource.look4dev.app.dao.userUrlPlatforms.userUrlOtherPlatforms;

import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.UserUrlOtherPlatform;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserUrlOtherPlatformRepository extends CrudRepository<UserUrlOtherPlatform, String> {
    List<UserUrlOtherPlatform> findAllByUserId(String userId);

    @Modifying
    @Query("delete from UserUrlOtherPlatform u where u.user.id = ?1")
    void deleteByUserId(String userId);
}
