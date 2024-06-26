package dev.arnoldatse.opensource.look4dev.core.users.userProfileDetails.usecases;

import dev.arnoldatse.opensource.look4dev.core.users.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails.MapperUserToUserProfileDetailsResponse;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.UserUrlPlatforms;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters.FileStorageUrlGetterAdapter;

import java.util.List;

public class GetUserProfileDetails {
    private final User user;
    private final UserUrlOtherPlatformRepository userUrlOtherPlatformRepository;
    private final UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository;
    private final FileStorageUrlGetterAdapter fileStorageUrlGetter;

    public GetUserProfileDetails(
            User user,
            UserUrlOtherPlatformRepository userUrlOtherPlatformRepository,
            UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository,
            FileStorageUrlGetterAdapter fileStorageUrlGetter
    ) {
        this.user = user;
        this.userUrlOtherPlatformRepository = userUrlOtherPlatformRepository;
        this.userUrlSupportedPlatformRepository = userUrlSupportedPlatformRepository;
        this.fileStorageUrlGetter = fileStorageUrlGetter;
    }

    public UserProfileDetailsResponseDto execute() {
        getUserPlatformsUrls();
        return new MapperUserToUserProfileDetailsResponse(user, fileStorageUrlGetter).mapFromUser();
    }

    private void getUserPlatformsUrls(){
        List<UserUrlOtherPlatform> userUrlOtherPlatforms = userUrlOtherPlatformRepository.findAllByUserId(user.getId());
        List<UserUrlSupportedPlatform> userUrlSupportedPlatforms = userUrlSupportedPlatformRepository.findAllByUserId(user.getId());
        UserUrlPlatforms userUrlPlatforms = new UserUrlPlatforms(userUrlOtherPlatforms, userUrlSupportedPlatforms);
        user.setPlatformsUrls(userUrlPlatforms);
    }
}
