package dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests;

import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest;

import java.util.List;
import java.util.Optional;

public interface UserResetPasswordRequestRepository {
    void save(UserResetPasswordRequest userResetPasswordRequest);
    Optional<UserResetPasswordRequest> findById(String id);
    UserResetPasswordRequest findFirstByUserId(String userId);
    List<UserResetPasswordRequest> findAllByUserId(String userId);
    void deleteAllByUserId(String userId);
}
