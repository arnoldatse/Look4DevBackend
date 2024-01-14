package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UpdateUserProfileDetailsRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperToUser;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperIntToUserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.UserUrlPlatforms;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.dtos.UserUrlPlatformsRequestResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.mappers.MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms;

import java.util.Arrays;
import java.util.List;

public class MapperUpdateUserProfileDetailsRequestToUser implements MapperToUser {
    private final UpdateUserProfileDetailsRequestDto updateUserProfileDetailsRequest;

    public MapperUpdateUserProfileDetailsRequestToUser(UpdateUserProfileDetailsRequestDto updateUserProfileDetailsRequest) {
        this.updateUserProfileDetailsRequest = updateUserProfileDetailsRequest;
    }

    @Override
    public User mapToUser() {
        User mappedUser = new User();
        mappedUser.setLastname(updateUserProfileDetailsRequest.getLastname());
        mappedUser.setFirstname(updateUserProfileDetailsRequest.getFirstname());
        mappedUser.setEmail(updateUserProfileDetailsRequest.getEmail());
        mappedUser.setPseudo(updateUserProfileDetailsRequest.getPseudo());
        mappedUser.setBio(updateUserProfileDetailsRequest.getBio());
        mappedUser.setUserProfiles(mapUserProfilesIdsToUserProfile(updateUserProfileDetailsRequest.getUserProfilesIds()));
        mappedUser.setPlatformsUrls(mapUserUrlPlatformsRequestResponseToUserUrlPlatforms(updateUserProfileDetailsRequest.getPlatformsUrls()));
        return mappedUser;
    }

    private List<UserProfile> mapUserProfilesIdsToUserProfile(int[] userProfilesIds) {
        return Arrays.stream(userProfilesIds).mapToObj(userProfileId -> new MapperIntToUserProfile(userProfileId).mapToUserProfile()).toList();
    }

    private UserUrlPlatforms mapUserUrlPlatformsRequestResponseToUserUrlPlatforms(UserUrlPlatformsRequestResponseDto userUrlPlatformsRequestResponseDto) {
        return new MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms(userUrlPlatformsRequestResponseDto).mapToUserUrlPlatforms();
    }
}
