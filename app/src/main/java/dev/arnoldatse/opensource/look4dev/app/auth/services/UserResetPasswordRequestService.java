package dev.arnoldatse.opensource.look4dev.app.auth.services;

import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserIdToFindRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.UserResetPasswordRequestRepository;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.usecases.ResetUserPassword;
import dev.arnoldatse.opensource.look4dev.details.email.StandardEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserResetPasswordRequestService {
    @Autowired
    UserResetPasswordRequestRepository userResetPasswordRequestRepository;
    @Autowired
    UserRepository userRepository;

    public DefaultHttpResponse create(UserIdToFindRequestDto userIdToFindRequest) throws NotFoundException {
        return new ResetUserPassword(userResetPasswordRequestRepository, userRepository, userIdToFindRequest, new StandardEmailSender()).execute();
    }
}
