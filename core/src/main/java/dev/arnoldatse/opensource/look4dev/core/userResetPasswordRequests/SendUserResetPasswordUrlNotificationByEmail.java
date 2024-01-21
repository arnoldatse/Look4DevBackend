package dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests;

import dev.arnoldatse.opensource.look4dev.core.email.EmailSender;
import dev.arnoldatse.opensource.look4dev.core.email.FailToSendEmailException;
import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest;

public class SendUserResetPasswordUrlNotificationByEmail implements SendUserResetPasswordUrlNotification {
    private final EmailSender emailSender;

    public SendUserResetPasswordUrlNotificationByEmail(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendUrl(UserResetPasswordRequest userResetPasswordRequest) throws Exception {
        try {
            emailSender.send(userResetPasswordRequest.getUser().getEmail(), "Reset password request", new Object());
        } catch (FailToSendEmailException e) {
            throw new Exception("Fail to send reset password notification by email: "+e.getMessage());
        }
    }
}
