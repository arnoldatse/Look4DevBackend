package dev.arnoldatse.opensource.look4dev.core.users.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserIdToFindRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import dev.arnoldatse.opensource.look4dev.core.http.exceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.SendUserResetPasswordUrlNotification;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.UserResetPasswordExpirationDateGenerator;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.UserResetPasswordIdGenerator;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.UserResetPasswordRequestRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;

import java.util.Date;
import java.util.Optional;

public class ResetUserPassword {
    private final UserResetPasswordRequestRepository userResetPasswordRequestRepository;
    private final UserRepository userRepository;
    private final UserIdToFindRequestDto userIdToFindRequestDto;
    private final SendUserResetPasswordUrlNotification sendUserResetPasswordUrlNotification;

    public ResetUserPassword(UserResetPasswordRequestRepository userResetPasswordRequestRepository, UserRepository userRepository, UserIdToFindRequestDto userIdToFindRequestDto, SendUserResetPasswordUrlNotification sendUserResetPasswordUrlNotification) {
        this.userResetPasswordRequestRepository = userResetPasswordRequestRepository;
        this.userRepository = userRepository;
        this.userIdToFindRequestDto = userIdToFindRequestDto;
        this.sendUserResetPasswordUrlNotification = sendUserResetPasswordUrlNotification;
    }

    public DefaultHttpResponse execute() throws NotFoundException {
        Optional<User> optionalUser = userRepository.findFirstByEmailOrPseudo(userIdToFindRequestDto.idToFind());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String userResetPasswordId = new UserResetPasswordIdGenerator(userResetPasswordRequestRepository).generateId();
            Date expirationDate = new UserResetPasswordExpirationDateGenerator().generateExpirationDate();
            deleteAllUserResetPasswordRequests(user);
            userResetPasswordRequestRepository.save(new UserResetPasswordRequest(userResetPasswordId, expirationDate, new Date(), user));
            sendUserResetPasswordUrlNotification.sendUrl();
            return new DefaultHttpResponse(HttpCode.OK, "Reset password request sent");
        }
        throw new NotFoundException("User not found");
    }

    private void deleteAllUserResetPasswordRequests(User user) {
        userResetPasswordRequestRepository.deleteAllByUserId(user.getId());
    }
}
