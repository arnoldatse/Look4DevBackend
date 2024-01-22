package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperFromUser;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperUserProfileToInt;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.UserUrlPlatforms;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.dtos.UserUrlPlatformsRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.mappers.MapperUserUrlPlatformsToUserUrlPlatformsRequestResponse;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FileStorageAdapter;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FilesTypesUrlsParts;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;

import java.util.List;

public class MapperUserToUserProfileDetailsResponse implements MapperFromUser<UserProfileDetailsResponseDto> {
    private final User user;
    private final FileStorageAdapter fileStorage;

    public MapperUserToUserProfileDetailsResponse(User user, FileStorageAdapter fileStorage) {
        this.user = user;
        this.fileStorage = fileStorage;
    }

    @Override
    public UserProfileDetailsResponseDto mapFromUser() {
        UserProfileDetailsResponseDto mappedUserProfileDetailsResponseDto = new UserProfileDetailsResponseDto();
        mappedUserProfileDetailsResponseDto.setLastname(user.getLastname());
        mappedUserProfileDetailsResponseDto.setFirstname(user.getFirstname());
        mappedUserProfileDetailsResponseDto.setEmail(user.getEmail());
        mappedUserProfileDetailsResponseDto.setPseudo(user.getPseudo());
        mappedUserProfileDetailsResponseDto.setBio(user.getBio());
        try {
            mappedUserProfileDetailsResponseDto.setPictureUrl(fileStorage.getUrl(FilesTypesUrlsParts.UserProfilePicture, user.getPicture()));
        } catch (NotFoundException ignored) { }
        try {
            mappedUserProfileDetailsResponseDto.setCvUrl(fileStorage.getUrl(FilesTypesUrlsParts.UserProfileCv, user.getCv()));
        } catch (NotFoundException ignored) { }
        mappedUserProfileDetailsResponseDto.setUserProfilesIds(mapUserProfilesToInts(user.getUserProfiles()));
        mappedUserProfileDetailsResponseDto.setPlatformsUrls(mapUserUrlPlatformsToUserUrlPlatformsRequestResponse(user.getPlatformsUrls()));
        return mappedUserProfileDetailsResponseDto;
    }

    private int[] mapUserProfilesToInts(List<UserProfile> userProfiles) {
        return userProfiles.stream().mapToInt(userProfile -> new MapperUserProfileToInt(userProfile).mapFromUserProfile()
        ).toArray();
    }

    private UserUrlPlatformsRequestResponseDto mapUserUrlPlatformsToUserUrlPlatformsRequestResponse(UserUrlPlatforms userUrlPlatforms) {
        return new MapperUserUrlPlatformsToUserUrlPlatformsRequestResponse(userUrlPlatforms).mapFromUserUrlPlatforms();
    }
}
