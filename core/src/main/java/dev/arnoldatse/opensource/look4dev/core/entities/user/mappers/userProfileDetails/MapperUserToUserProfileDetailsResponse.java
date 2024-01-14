package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperFromUser;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperUserProfileToInt;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.UserUrlPlatforms;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.dtos.UserUrlPlatformsRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.mappers.MapperUserUrlPlatformsToUserUrlPlatformsRequestResponse;

import java.util.List;

public class MapperUserToUserProfileDetailsResponse implements MapperFromUser<UserProfileDetailsResponseDto> {
    private final User user;

    public MapperUserToUserProfileDetailsResponse(User user) {
        this.user = user;
    }

    @Override
    public UserProfileDetailsResponseDto mapFromUser() {
        UserProfileDetailsResponseDto mappedUserProfileDetailsResponseDto = new UserProfileDetailsResponseDto();
        mappedUserProfileDetailsResponseDto.setLastname(user.getLastname());
        mappedUserProfileDetailsResponseDto.setFirstname(user.getFirstname());
        mappedUserProfileDetailsResponseDto.setEmail(user.getEmail());
        mappedUserProfileDetailsResponseDto.setPseudo(user.getPseudo());
        mappedUserProfileDetailsResponseDto.setBio(user.getBio());
        mappedUserProfileDetailsResponseDto.setPicturePath(user.getPicture());
        mappedUserProfileDetailsResponseDto.setCvPath(user.getCv());
        mappedUserProfileDetailsResponseDto.setUserProfilesIds(mapUserProfilesToInts(user.getUserProfiles()));
        mappedUserProfileDetailsResponseDto.setPlatformsUrls(mapUserUrlPlatformsToUserUrlPlatformsRequestResponse(user.getPlatformsUrls()));
        return mappedUserProfileDetailsResponseDto;
    }

    private int[] mapUserProfilesToInts(List<UserProfile> userProfiles){
        return userProfiles.stream().mapToInt(userProfile->new MapperUserProfileToInt(userProfile).mapFromUserProfile()
        ).toArray();
    }

    private UserUrlPlatformsRequestResponseDto mapUserUrlPlatformsToUserUrlPlatformsRequestResponse(UserUrlPlatforms userUrlPlatforms){
        return new MapperUserUrlPlatformsToUserUrlPlatformsRequestResponse(userUrlPlatforms).mapFromUserUrlPlatforms();
    }
}
