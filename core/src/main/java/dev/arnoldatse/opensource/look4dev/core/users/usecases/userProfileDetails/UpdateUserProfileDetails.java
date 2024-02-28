package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails.MapperUserToUserProfileDetailsResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.user.updaters.UpdateUserWithUserProfileDetailsUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters.FileStorageUrlGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.RepositoryException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.UserUserProfileRepository;

public class UpdateUserProfileDetails {
    private final UserProfileDetailsUpdateRequestDto updateUserProfileDetailsRequestDto;
    private final User user;
    private final UserRepository userRepository;
    private final UserUrlOtherPlatformRepository userUrlOtherPlatformRepository;
    private final UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository;
    private final UserUserProfileRepository userUserProfileRepository;
    private final FileStorageUrlGetterAdapter fileStorageUrl;

    public UpdateUserProfileDetails(
            UserProfileDetailsUpdateRequestDto updateUserProfileDetailsRequestDto,
            User user,
            UserRepository userRepository,
            UserUrlOtherPlatformRepository userUrlOtherPlatformRepository,
            UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository,
            UserUserProfileRepository userUserProfileRepository,
            FileStorageUrlGetterAdapter fileStorageUrl) {
        this.updateUserProfileDetailsRequestDto = updateUserProfileDetailsRequestDto;
        this.user = user;
        this.userRepository = userRepository;
        this.userUrlOtherPlatformRepository = userUrlOtherPlatformRepository;
        this.userUrlSupportedPlatformRepository = userUrlSupportedPlatformRepository;
        this.userUserProfileRepository = userUserProfileRepository;
        this.fileStorageUrl = fileStorageUrl;
    }

    public UserProfileDetailsResponseDto execute() throws RepositoryException {
        new UpdateUserWithUserProfileDetailsUpdateRequestDto(user, updateUserProfileDetailsRequestDto).update();
        deleteAllUserProfiles(user.getId());
        deleteAllUserUrlPlatforms(user.getId());
        User userCreated = userRepository.updateUserDetails(user);
        return new MapperUserToUserProfileDetailsResponse(userCreated, fileStorageUrl).mapFromUser();
    }

    private void deleteAllUserProfiles(String userId) {
        userUserProfileRepository.deleteAllByUserId(userId);
    }

    private void deleteAllUserUrlPlatforms(String userId) {
        userUrlOtherPlatformRepository.deleteAllByUserId(userId);
        userUrlSupportedPlatformRepository.deleteAllByUserId(userId);
    }
}
