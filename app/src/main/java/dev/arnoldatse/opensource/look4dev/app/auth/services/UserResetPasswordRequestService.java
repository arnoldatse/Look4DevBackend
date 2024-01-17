package dev.arnoldatse.opensource.look4dev.app.auth.services;

import dev.arnoldatse.opensource.look4dev.app.dao.userResetPasswordRequest.CoreUserResetPasswordRequestRepositoryImpl;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserIdToFindRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.exceptions.NotFoundException;
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

    public DefaultHttpResponse create(UserIdToFindRequestDto userIdToFindRequest) throws NotFoundException {
        return new ResetUserPassword(userResetPasswordRequestRepository, userRepository, userIdToFindRequest, new SendUserResetPasswordUrlNotificationByEmail()).execute();
    }
}
