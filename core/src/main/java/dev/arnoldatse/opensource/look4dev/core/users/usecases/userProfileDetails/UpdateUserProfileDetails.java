package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.UserUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.UserUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails.MapperUserToUserProfileDetailsResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.user.updaters.UpdateUserWithUserProfileDetailsUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.exceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.UserUserProfileRepository;

import java.util.Optional;

public class UpdateUserProfileDetails {
    private final UserProfileDetailsUpdateRequestDto updateUserProfileDetailsRequestDto;
    private final String userId;
    private final UserRepository userRepository;
    private final UserUrlOtherPlatformRepository userUrlOtherPlatformRepository;
    private final UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository;
    private final UserUserProfileRepository userUserProfileRepository;

    public UpdateUserProfileDetails(
            UserProfileDetailsUpdateRequestDto updateUserProfileDetailsRequestDto,
            String userId,
            UserRepository userRepository,
            UserUrlOtherPlatformRepository userUrlOtherPlatformRepository,
            UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository,
            UserUserProfileRepository userUserProfileRepository
    ) {
        this.updateUserProfileDetailsRequestDto = updateUserProfileDetailsRequestDto;
        this.userId = userId;
        this.userRepository = userRepository;
        this.userUrlOtherPlatformRepository = userUrlOtherPlatformRepository;
        this.userUrlSupportedPlatformRepository = userUrlSupportedPlatformRepository;
        this.userUserProfileRepository = userUserProfileRepository;
    }

    public UserProfileDetailsResponseDto execute() throws NotFoundException {
        Optional<User> optionalUser = userRepository.findFirstById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            new UpdateUserWithUserProfileDetailsUpdateRequestDto(user, updateUserProfileDetailsRequestDto).update();
            deleteAllUserProfiles(user.getId());
            deleteAllUserUrlPlatforms(user.getId());
            User userCreated = userRepository.saveUser(user);
            return new MapperUserToUserProfileDetailsResponse(userCreated).mapFromUser();
        }
        throw new NotFoundException("User not found");
    }

    private void deleteAllUserProfiles(String userId){
        userUserProfileRepository.deleteAllByUserId(userId);
    }

    private void deleteAllUserUrlPlatforms(String userId) {
        userUrlOtherPlatformRepository.deleteAllByUserId(userId);
        userUrlSupportedPlatformRepository.deleteAllByUserId(userId);
    }
}
