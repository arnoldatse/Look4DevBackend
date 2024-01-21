package dev.arnoldatse.opensource.look4dev.app.dao.userResetPasswordRequest;

import dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest.UserResetPasswordRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface UserResetPasswordRequestRepository extends CrudRepository<UserResetPasswordRequest, String> {
    @Query(value = "SELECT * FROM user_reset_password_requests AS r WHERE r.user_id = ?1 LIMIT 1", nativeQuery = true)
    UserResetPasswordRequest findFirstByUserId(String userId);
    @Query("select r from UserResetPasswordRequest r where r.user.id = ?1")
    List<UserResetPasswordRequest> findAllByUserId(String userId);
    @Modifying
    @Query("delete from UserResetPasswordRequest r where r.user.id = ?1")
    void deleteAllByUserId(String userId);
}
