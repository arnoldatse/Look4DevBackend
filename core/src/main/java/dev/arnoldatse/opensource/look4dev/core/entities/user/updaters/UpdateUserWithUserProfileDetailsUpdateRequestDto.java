package dev.arnoldatse.opensource.look4dev.core.entities.user.updaters;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperIntToUserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.mappers.MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms;

import java.util.Arrays;

public class UpdateUserWithUserProfileDetailsUpdateRequestDto {
    private final User user;
    private final UserProfileDetailsUpdateRequestDto userProfileDetailsUpdateRequestDto;

    public UpdateUserWithUserProfileDetailsUpdateRequestDto(User user, UserProfileDetailsUpdateRequestDto userProfileDetailsUpdateRequestDto) {
        this.user = user;
        this.userProfileDetailsUpdateRequestDto = userProfileDetailsUpdateRequestDto;
    }

    public void update(){
        user.setLastname(userProfileDetailsUpdateRequestDto.getLastname());
        user.setFirstname(userProfileDetailsUpdateRequestDto.getFirstname());
        user.setEmail(userProfileDetailsUpdateRequestDto.getEmail());
        user.setPseudo(userProfileDetailsUpdateRequestDto.getPseudo());
        user.setBio(userProfileDetailsUpdateRequestDto.getBio());
        user.setUserProfiles(
                Arrays.stream(userProfileDetailsUpdateRequestDto.getUserProfilesIds())
                        .mapToObj(userProfileId -> new MapperIntToUserProfile(userProfileId).mapToUserProfile())
                        .toList()
        );
        user.setPlatformsUrls(
                new MapperUserUrlPlatformsRequestResponseToUserUrlPlatforms(
                        userProfileDetailsUpdateRequestDto.getPlatformsUrls()
                ).mapToUserUrlPlatforms()
        );
    }
}
