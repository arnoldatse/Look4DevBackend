package dev.arnoldatse.opensource.look4dev.core.users.userResetPasswordRequests;

import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest;

import java.util.List;
import java.util.Optional;

public interface UserResetPasswordRequestRepository {
    void save(UserResetPasswordRequest userResetPasswordRequest);
    Optional<UserResetPasswordRequest> findById(String id);
    Optional<UserResetPasswordRequest> findFirstByUserId(String userId);
    List<UserResetPasswordRequest> findAllByUserId(String userId);
    void deleteAllByUserId(String userId);
}
