package dev.arnoldatse.opensource.look4dev.core.users.usecases;

import dev.arnoldatse.opensource.look4dev.core.email.EmailSender;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserIdToFindRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.*;
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
    private final EmailSender emailSender;

    public ResetUserPassword(UserResetPasswordRequestRepository userResetPasswordRequestRepository, UserRepository userRepository, UserIdToFindRequestDto userIdToFindRequestDto, EmailSender emailSender) {
        this.userResetPasswordRequestRepository = userResetPasswordRequestRepository;
        this.userRepository = userRepository;
        this.userIdToFindRequestDto = userIdToFindRequestDto;
        this.emailSender = emailSender;
    }

    public DefaultHttpResponse execute() throws NotFoundException {
        Optional<User> optionalUser = userRepository.findFirstByEmailOrPseudo(userIdToFindRequestDto.idToFind());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String userResetPasswordId = new UserResetPasswordIdGenerator(userResetPasswordRequestRepository).generateId();
            Date expirationDate = new UserResetPasswordExpirationDateGenerator().generateExpirationDate();
            deleteAllUserResetPasswordRequests(user);
            UserResetPasswordRequest userResetPasswordRequest = new UserResetPasswordRequest(userResetPasswordId, expirationDate, new Date(), user);
            userResetPasswordRequestRepository.save(userResetPasswordRequest);
            try {
                new SendUserResetPasswordUrlNotificationByEmail(emailSender).sendUrl(userResetPasswordRequest);
            } catch (Exception ignored) {}
            return new DefaultHttpResponse(HttpCode.OK, "Reset password request sent");
        }
        throw new NotFoundException("User not found");
    }

    private void deleteAllUserResetPasswordRequests(User user) {
        userResetPasswordRequestRepository.deleteAllByUserId(user.getId());
    }
}
