package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.UserUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.UserUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UpdateUserProfileDetailsRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails.MapperUserToUserProfileDetailsResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperIntToUserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.mappers.MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.UserUserProfileRepository;

import java.util.Arrays;
import java.util.Optional;

public class UpdateUserProfileDetails {
    private final UpdateUserProfileDetailsRequestDto updateUserProfileDetailsRequestDto;
    private final String userId;
    private final UserRepository userRepository;
    private final UserUrlOtherPlatformRepository userUrlOtherPlatformRepository;
    private final UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository;
    private final UserUserProfileRepository userUserProfileRepository;

    public UpdateUserProfileDetails(
            UpdateUserProfileDetailsRequestDto updateUserProfileDetailsRequestDto,
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

    public UserProfileDetailsResponseDto execute() throws NotFoundHttpErrorException {
        Optional<User> optionalUser = userRepository.findFirstById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            updateUserWithUserProfileDetailsRequestResponseDto(user, updateUserProfileDetailsRequestDto);
            deleteAllUserProfiles(user.getId());
            deleteAllUserUrlPlatforms(user.getId());
            User userCreated = userRepository.saveUser(user);
            return new MapperUserToUserProfileDetailsResponse(userCreated).mapFromUser();
        }
        throw new NotFoundHttpErrorException("User not found");
    }

    private void deleteAllUserProfiles(String userId){
        userUserProfileRepository.deleteAllByUserId(userId);
    }

    private void deleteAllUserUrlPlatforms(String userId) {
        userUrlOtherPlatformRepository.deleteAllByUserId(userId);
        userUrlSupportedPlatformRepository.deleteAllByUserId(userId);
    }

    private void updateUserWithUserProfileDetailsRequestResponseDto(User user, UpdateUserProfileDetailsRequestDto updateUserProfileDetailsRequestDto) {
        user.setLastname(updateUserProfileDetailsRequestDto.getLastname());
        user.setFirstname(updateUserProfileDetailsRequestDto.getFirstname());
        user.setEmail(updateUserProfileDetailsRequestDto.getEmail());
        user.setPseudo(updateUserProfileDetailsRequestDto.getPseudo());
        user.setBio(updateUserProfileDetailsRequestDto.getBio());
        user.setUserProfiles(
                Arrays.stream(updateUserProfileDetailsRequestDto.getUserProfilesIds())
                        .mapToObj(userProfileId -> new MapperIntToUserProfile(userProfileId).mapToUserProfile())
                        .toList()
        );
        user.setPlatformsUrls(
                new MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms(
                        updateUserProfileDetailsRequestDto.getPlatformsUrls()
                ).mapToUserUrlPlatforms()
        );
    }
}
