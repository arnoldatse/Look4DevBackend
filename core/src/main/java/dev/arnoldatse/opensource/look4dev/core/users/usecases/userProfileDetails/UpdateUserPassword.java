package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.PasswordUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.HttpCode;
import dev.arnoldatse.opensource.look4dev.core.users.UserPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;

public class UpdateUserPassword {
    private final User user;
    private final PasswordUpdateRequestDto passwordUpdateRequestDto;
    private final UserRepository userRepository;
    private final UserPasswordEncoder userPasswordEncoder;

    public UpdateUserPassword(User user, PasswordUpdateRequestDto passwordUpdateRequestDto, UserRepository userRepository, UserPasswordEncoder userPasswordEncoder) {
        this.user = user;
        this.passwordUpdateRequestDto = passwordUpdateRequestDto;
        this.userRepository = userRepository;
        this.userPasswordEncoder = userPasswordEncoder;
    }

    public DefaultHttpResponse execute() throws Exception {
        try{
            userRepository.updateUserPassword(user.getId(), userPasswordEncoder.encode(passwordUpdateRequestDto.getPassword()));
            return new DefaultHttpResponse(HttpCode.OK, "Password updated with success");
        }
        catch (Exception e){
            throw new Exception("Error occurred during password updating: "+e.getMessage());
        }
    }
}
