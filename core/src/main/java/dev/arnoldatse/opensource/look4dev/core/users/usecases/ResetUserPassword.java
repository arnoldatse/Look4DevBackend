package dev.arnoldatse.opensource.look4dev.core.users.usecases;

import dev.arnoldatse.opensource.look4dev.core.UserResetPasswordRequests.SendUserResetPasswordRequestByEmail;
import dev.arnoldatse.opensource.look4dev.core.UserResetPasswordRequests.UserResetPasswordExpirationDateGenerator;
import dev.arnoldatse.opensource.look4dev.core.UserResetPasswordRequests.UserResetPasswordIdGenerator;
import dev.arnoldatse.opensource.look4dev.core.UserResetPasswordRequests.UserResetPasswordRequestRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpSuccess;

import java.util.Date;

public class ResetUserPassword {
    private final User user;
    private final UserResetPasswordRequestRepository userResetPasswordRequestRepository;
    private final SendUserResetPasswordRequestByEmail sendUserResetPasswordRequestByEmail;

    public ResetUserPassword(UserResetPasswordRequestRepository userResetPasswordRequestRepository, User user, SendUserResetPasswordRequestByEmail sendUserResetPasswordRequestByEmail) {
        this.userResetPasswordRequestRepository = userResetPasswordRequestRepository;
        this.user = user;
        this.sendUserResetPasswordRequestByEmail = sendUserResetPasswordRequestByEmail;
    }

    public DefaultHttpSuccess execute() {
        String userResetPasswordId = new UserResetPasswordIdGenerator(userResetPasswordRequestRepository).generateId();
        Date expirationDate = new UserResetPasswordExpirationDateGenerator().generateExpirationDate();
        deleteAllUserResetPasswordRequests();
        userResetPasswordRequestRepository.saveUserResetPasswordRequest(new UserResetPasswordRequest(userResetPasswordId, expirationDate, new Date(), user));
        sendUserResetPasswordRequestByEmail.sendEmail();
        return new DefaultHttpSuccess("Reset password request sent");
    }

    private void deleteAllUserResetPasswordRequests() {
        userResetPasswordRequestRepository.deleteAllByUserId(user.getId());
    }
}
