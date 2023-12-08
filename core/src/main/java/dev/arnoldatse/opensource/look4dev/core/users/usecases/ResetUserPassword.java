package dev.arnoldatse.opensource.look4dev.core.users.usecases;

import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.SendUserResetPasswordUrlNotification;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.UserResetPasswordExpirationDateGenerator;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.UserResetPasswordIdGenerator;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.UserResetPasswordRequestRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpSuccess;

import java.util.Date;

public class ResetUserPassword {
    private final User user;
    private final UserResetPasswordRequestRepository userResetPasswordRequestRepository;
    private final SendUserResetPasswordUrlNotification sendUserResetPasswordUrlNotification;

    public ResetUserPassword(UserResetPasswordRequestRepository userResetPasswordRequestRepository, User user, SendUserResetPasswordUrlNotification sendUserResetPasswordUrlNotification) {
        this.userResetPasswordRequestRepository = userResetPasswordRequestRepository;
        this.user = user;
        this.sendUserResetPasswordUrlNotification = sendUserResetPasswordUrlNotification;
    }

    public DefaultHttpSuccess execute() {
        String userResetPasswordId = new UserResetPasswordIdGenerator(userResetPasswordRequestRepository).generateId();
        Date expirationDate = new UserResetPasswordExpirationDateGenerator().generateExpirationDate();
        deleteAllUserResetPasswordRequests();
        userResetPasswordRequestRepository.save(new UserResetPasswordRequest(userResetPasswordId, expirationDate, new Date(), user));
        sendUserResetPasswordUrlNotification.sendUrl();
        return new DefaultHttpSuccess("Reset password request sent");
    }

    private void deleteAllUserResetPasswordRequests() {
        userResetPasswordRequestRepository.deleteAllByUserId(user.getId());
    }
}
