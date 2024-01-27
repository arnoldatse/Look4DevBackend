package dev.arnoldatse.opensource.look4dev.core.entities.user.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.dtos.UserProfileResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperUserProfileToUserProfileResponse;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters.FileStorageUrlGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesUrlsParts;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;

public class MapperUserToUserResponse implements MapperFromUser<UserResponseDto> {
    private final User user;
    private final FileStorageUrlGetterAdapter fileStorageUrlGetterAdapter;

    public MapperUserToUserResponse(User user, FileStorageUrlGetterAdapter fileStorageUrlGetterAdapter){
        this.user = user;
        this.fileStorageUrlGetterAdapter = fileStorageUrlGetterAdapter;
    }

    @Override
    public UserResponseDto mapFromUser() {
        UserResponseDto mappedUserResponse = new UserResponseDto();
        mappedUserResponse.setId(user.getId());
        mappedUserResponse.setLastname(user.getLastname());
        mappedUserResponse.setFirstname(user.getFirstname());
        mappedUserResponse.setEmail(user.getEmail());
        mappedUserResponse.setPseudo(user.getPseudo());
        try {
            mappedUserResponse.setPictureUrl(fileStorageUrlGetterAdapter.getUrl(FilesTypesUrlsParts.UserProfilePicture, user.getPicture()));
        } catch (NotFoundException ignored) { }
        mappedUserResponse.setBio(user.getBio());
        try {
            mappedUserResponse.setCvUrl(fileStorageUrlGetterAdapter.getUrl(FilesTypesUrlsParts.UserProfileCv, user.getCv()));
        } catch (NotFoundException ignored) { }
        mappedUserResponse.setCreatedAt(user.getCreatedAt());
        mappedUserResponse.setUpdatedAt(user.getUpdatedAt());
        mappedUserResponse.setUserProfiles(user.getUserProfiles().stream().map(this::mapUserProfileToUserProfileResponse).toList());
        return mappedUserResponse;
    }

    private UserProfileResponseDto mapUserProfileToUserProfileResponse(UserProfile userProfile){
        return new MapperUserProfileToUserProfileResponse(userProfile).mapFromUserProfile();
    }
}
