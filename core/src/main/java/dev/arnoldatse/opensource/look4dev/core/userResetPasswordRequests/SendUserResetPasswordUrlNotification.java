package dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests;

import dev.arnoldatse.opensource.look4dev.core.email.FailedToSendEmailException;
import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest;

public interface SendUserResetPasswordUrlNotification {
    void sendUrl(UserResetPasswordRequest userResetPasswordRequest) throws FailedToSendEmailException;
}
