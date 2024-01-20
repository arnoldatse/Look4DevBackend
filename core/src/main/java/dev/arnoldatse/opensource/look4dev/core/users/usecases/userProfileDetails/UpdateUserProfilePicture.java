package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserPicturePathResponseDto;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FailToStoreException;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FilesDirectories;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FileStorage;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.utils.RandomString;

import java.util.Optional;

public class UpdateUserProfilePicture {
    private final String userId;
    private final UserRepository userRepository;
    private final FileStorage fileStorage;
    private final Object file;

    public UpdateUserProfilePicture(String userId, UserRepository userRepository, FileStorage fileStorage, Object file) {
        this.userId = userId;
        this.userRepository = userRepository;
        this.fileStorage = fileStorage;
        this.file = file;
    }

    UserPicturePathResponseDto execute() throws Exception{
        Optional<User> optionalUser = userRepository.findFirstById(userId);
        if (optionalUser.isPresent()) {
            String fileExtention = "";
            String fileName = generateFileName();
            String fullFileName = fileName+"."+fileExtention;
            try {
                fileStorage.store(file, fileName, fileExtention, FilesDirectories.UserProfilePicture);
                userRepository.updateUserPicture(userId, fullFileName);
                return new UserPicturePathResponseDto(fullFileName);
            }
            catch (FailToStoreException e){
                throw new Exception("Fail to store file: "+e.getMessage());
            }

        }
        throw new NotFoundException("User not found");
    }

    private String generateFileName(){
        return userId+RandomString.generateRandomString(5);
    }
}
