package dev.arnoldatse.opensource.look4dev.core.UserResetPasswordRequests;

import dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.UserResetPasswordRequest;

import java.util.List;

public interface UserResetPasswordRequestRepository {
    UserResetPasswordRequest saveUserResetPasswordRequest(UserResetPasswordRequest userResetPasswordRequest);
    UserResetPasswordRequest findById(String id);
    UserResetPasswordRequest findFirstByUserId(String userId);
    List<UserResetPasswordRequest> findAllByUserId(String userId);
    void deleteAllByUserId(String userId);
}
