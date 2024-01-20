package dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto;

import dev.arnoldatse.opensource.look4dev.core.http.TypeFilePartUrls;

public class UserPicturePathResponseDto {
    String picturePath;

    public UserPicturePathResponseDto(String pictureName) {
        this.picturePath = TypeFilePartUrls.UserProfilePicture.getValue()+pictureName;
    }
}
