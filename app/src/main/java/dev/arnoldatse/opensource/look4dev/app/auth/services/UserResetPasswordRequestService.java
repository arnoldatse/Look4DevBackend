package dev.arnoldatse.opensource.look4dev.app.auth.services;

import dev.arnoldatse.opensource.look4dev.app.dao.userResetPasswordRequest.UserResetPasswordRequestRepositoryImpl;
import dev.arnoldatse.opensource.look4dev.app.exceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserIdToFindRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpSuccess;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.usecases.ResetUserPassword;
import dev.arnoldatse.opensource.look4dev.details.SendUserResetPasswordUrlNotificationByEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserResetPasswordRequestService {
    @Autowired
    UserResetPasswordRequestRepositoryImpl userResetPasswordRequestRepository;
    @Autowired
    UserRepository userRepository;
    public DefaultHttpSuccess create(UserIdToFindRequestDto userIdToFindRequest) throws NotFoundException {
        Optional<User> optionalUser = userRepository.findFirstByEmailOrPseudo(userIdToFindRequest.idToFind());
        if(optionalUser.isPresent()){
            return new ResetUserPassword(userResetPasswordRequestRepository, optionalUser.get(), new SendUserResetPasswordUrlNotificationByEmail()).execute();
        }
        throw new NotFoundException("User not found");
    }
}
