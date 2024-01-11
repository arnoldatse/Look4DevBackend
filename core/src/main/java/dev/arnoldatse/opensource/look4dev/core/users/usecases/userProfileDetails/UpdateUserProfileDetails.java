package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UpdateUserProfileDetailsRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails.MapperUserToUserProfileDetailsResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.mappers.MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;

import java.util.Optional;

public class UpdateUserProfileDetails {
    private final UpdateUserProfileDetailsRequestDto updateUserProfileDetailsRequestDto;
    private final String userId;
    private final UserRepository userRepository;

    public UpdateUserProfileDetails(UpdateUserProfileDetailsRequestDto updateUserProfileDetailsRequestDto, String userId, UserRepository userRepository) {
        this.updateUserProfileDetailsRequestDto = updateUserProfileDetailsRequestDto;
        this.userId = userId;
        this.userRepository = userRepository;
    }

    public UserProfileDetailsResponseDto execute() throws NotFoundHttpErrorException {
        Optional<User> optionalUser = userRepository.findFirstById(userId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            updateUserWithUserProfileDetailsRequestResponseDto(user, updateUserProfileDetailsRequestDto);
            User userCreated = userRepository.saveUser(user);
            return new MapperUserToUserProfileDetailsResponse(userCreated).mapFromUser();
        }
        throw new NotFoundHttpErrorException("User not found");
    }

    private void updateUserWithUserProfileDetailsRequestResponseDto(User user, UpdateUserProfileDetailsRequestDto updateUserProfileDetailsRequestDto) {
        user.setLastname(updateUserProfileDetailsRequestDto.getLastname());
        user.setFirstname(updateUserProfileDetailsRequestDto.getFirstname());
        user.setEmail(updateUserProfileDetailsRequestDto.getEmail());
        user.setPseudo(updateUserProfileDetailsRequestDto.getPseudo());
        user.setBio(updateUserProfileDetailsRequestDto.getBio());
        user.setPlatformsUrls(
                new MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms(
                        updateUserProfileDetailsRequestDto.getPlatformsUrls()
                ).mapToUserUrlPlatforms()
        );
    }
}
