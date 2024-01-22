package dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests;

import dev.arnoldatse.opensource.look4dev.core.email.EmailSenderAdapter;
import dev.arnoldatse.opensource.look4dev.core.email.FailedToSendEmailException;
import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest;

public class SendUserResetPasswordUrlNotificationByEmail implements SendUserResetPasswordUrlNotification {
    private final EmailSenderAdapter emailSender;

    public SendUserResetPasswordUrlNotificationByEmail(EmailSenderAdapter emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendUrl(UserResetPasswordRequest userResetPasswordRequest) throws FailedToSendEmailException {
        try {
            emailSender.send(userResetPasswordRequest.getUser().getEmail(), "Reset password request", new Object());
        } catch (FailedToSendEmailException e) {
            throw new FailedToSendEmailException("Failed to send reset password request email: "+e.getMessage());
        }
    }
}
