package dev.arnoldatse.opensource.look4dev.core.users.usecases;

import dev.arnoldatse.opensource.look4dev.core.email.EmailSenderAdapter;
import dev.arnoldatse.opensource.look4dev.core.email.FailedToSendEmailException;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserIdToFindRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userResetPasswordRequests.usecases.SendUserResetPasswordUrlNotificationByEmail;
import dev.arnoldatse.opensource.look4dev.core.users.userResetPasswordRequests.usecases.UserResetPasswordExpirationDateGenerator;
import dev.arnoldatse.opensource.look4dev.core.users.userResetPasswordRequests.usecases.UserResetPasswordIdGenerator;
import dev.arnoldatse.opensource.look4dev.core.users.userResetPasswordRequests.UserResetPasswordRequestRepository;

import java.util.Date;
import java.util.Optional;

public class ResetUserPassword {
    private final UserResetPasswordRequestRepository userResetPasswordRequestRepository;
    private final UserRepository userRepository;
    private final UserIdToFindRequestDto userIdToFindRequestDto;
    private final EmailSenderAdapter emailSender;

    public ResetUserPassword(UserResetPasswordRequestRepository userResetPasswordRequestRepository, UserRepository userRepository, UserIdToFindRequestDto userIdToFindRequestDto, EmailSenderAdapter emailSender) {
        this.userResetPasswordRequestRepository = userResetPasswordRequestRepository;
        this.userRepository = userRepository;
        this.userIdToFindRequestDto = userIdToFindRequestDto;
        this.emailSender = emailSender;
    }

    public DefaultHttpResponse execute() throws NotFoundException, FailedToSendEmailException {
        Optional<User> optionalUser = userRepository.findFirstByEmailOrPseudo(userIdToFindRequestDto.idToFind());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String userResetPasswordId = new UserResetPasswordIdGenerator(userResetPasswordRequestRepository).generateId();
            Date expirationDate = new UserResetPasswordExpirationDateGenerator().generateExpirationDate();
            deleteAllUserResetPasswordRequests(user);
            UserResetPasswordRequest userResetPasswordRequest = new UserResetPasswordRequest(userResetPasswordId, expirationDate, new Date(), user);
            userResetPasswordRequestRepository.save(userResetPasswordRequest);
            new SendUserResetPasswordUrlNotificationByEmail(emailSender).sendUrl(userResetPasswordRequest);
            return new DefaultHttpResponse(HttpCode.OK, "Reset password request sent");
        }
        throw new NotFoundException("User not found");
    }

    private void deleteAllUserResetPasswordRequests(User user) {
        userResetPasswordRequestRepository.deleteAllByUserId(user.getId());
    }
}
