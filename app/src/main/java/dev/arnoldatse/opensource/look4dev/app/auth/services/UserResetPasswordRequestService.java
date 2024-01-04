package dev.arnoldatse.opensource.look4dev.app.auth.services;

import dev.arnoldatse.opensource.look4dev.app.dao.userResetPasswordRequest.CoreUserResetPasswordRequestRepositoryImpl;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserIdToFindRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpSuccessResponse;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.usecases.ResetUserPassword;
import dev.arnoldatse.opensource.look4dev.details.SendUserResetPasswordUrlNotificationByEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserResetPasswordRequestService {
    @Autowired
    CoreUserResetPasswordRequestRepositoryImpl userResetPasswordRequestRepository;
    @Autowired
    UserRepository userRepository;

    public DefaultHttpSuccessResponse create(UserIdToFindRequestDto userIdToFindRequest) throws NotFoundHttpErrorException {
        return new ResetUserPassword(userResetPasswordRequestRepository, userRepository, userIdToFindRequest, new SendUserResetPasswordUrlNotificationByEmail()).execute();
    }
}
