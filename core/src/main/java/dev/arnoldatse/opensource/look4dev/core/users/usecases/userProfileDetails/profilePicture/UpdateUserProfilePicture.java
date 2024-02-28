package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails.profilePicture;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsFileUrlResponseDto;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.FileExtensions;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters.FileStoragePersistAndUrlGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesDirectories;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesUrlsParts;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.CheckSupportedFileExtension;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.FileExtensionNotSupportedException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.utils.RandomString;

public class UpdateUserProfilePicture<PictureFile> {
    private final User user;
    private final UserRepository userRepository;
    private final FileStoragePersistAndUrlGetterAdapter<PictureFile> fileStoragePersistAndUrlGetter;
    private final PictureFile picture;
    private final String fileExtention;

    public UpdateUserProfilePicture(User user, UserRepository userRepository, FileStoragePersistAndUrlGetterAdapter<PictureFile> fileStoragePersistAndUrlGetter, PictureFile picture, String fileExtention) {
        this.user = user;
        this.userRepository = userRepository;
        this.fileStoragePersistAndUrlGetter = fileStoragePersistAndUrlGetter;
        this.picture = picture;
        this.fileExtention = fileExtention;
    }

    public UserProfileDetailsFileUrlResponseDto execute() throws FailedToStoreFileException, NotFoundException, FileExtensionNotSupportedException {
        if (CheckSupportedFileExtension.check(fileExtention, FileExtensions.images())){
            deleteOldProfilePicture();

            String fileName = generateFileName();
            String fullFileName = fileName + "." + fileExtention;

            fileStoragePersistAndUrlGetter.store(picture, fileName, fileExtention, FilesTypesDirectories.UserProfilePicture);
            userRepository.updateUserPicture(user.getId(), fullFileName);
            return new UserProfileDetailsFileUrlResponseDto(fileStoragePersistAndUrlGetter.getUrl(FilesTypesUrlsParts.UserProfilePicture, fullFileName));
        }
        throw new FileExtensionNotSupportedException();
    }

    private void deleteOldProfilePicture() {
        String oldProfilePicture = user.getPicture();
        if (oldProfilePicture != null) {
            fileStoragePersistAndUrlGetter.delete(oldProfilePicture, FilesTypesDirectories.UserProfilePicture);
        }
    }

    private String generateFileName() {
        return user.getId() + RandomString.generateRandomString(5);
    }
}
