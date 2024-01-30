package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails.profileCv;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsFileUrlResponseDto;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.CheckSupportedFileExtension;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters.FileStoragePersistAndUrlGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesDirectories;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesUrlsParts;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.FileExtensionNotSupportedException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.utils.RandomString;

public class UpdateUserProfileCv<T> {
    private final User user;
    private final UserRepository userRepository;
    private final FileStoragePersistAndUrlGetterAdapter<T> fileStoragePersistWithUrlGetter;
    private final T cv;
    private final String fileExtention;

    public UpdateUserProfileCv(User user, UserRepository userRepository, FileStoragePersistAndUrlGetterAdapter<T> fileStoragePersistWithUrlGetter, T cv, String fileExtention) {
        this.user = user;
        this.userRepository = userRepository;
        this.fileStoragePersistWithUrlGetter = fileStoragePersistWithUrlGetter;
        this.cv = cv;
        this.fileExtention = fileExtention;
    }

    public UserProfileDetailsFileUrlResponseDto execute() throws FailedToStoreFileException, NotFoundException, FileExtensionNotSupportedException {
        if (CheckSupportedFileExtension.check(fileExtention, UserProfileCvAuthorizedExtensions.get())){
            deleteOldCv();

            String fileName = generateFileName();
            String fullFileName = fileName + "." + fileExtention;

            fileStoragePersistWithUrlGetter.store(cv, fileName, fileExtention, FilesTypesDirectories.UserProfileCv);
            userRepository.updateUserCv(user.getId(), fullFileName);
            return new UserProfileDetailsFileUrlResponseDto(fileStoragePersistWithUrlGetter.getUrl(FilesTypesUrlsParts.UserProfileCv, fullFileName));
        }
        throw new FileExtensionNotSupportedException();

    }

    private void deleteOldCv() {
        String oldCv = user.getCv();
        if (oldCv != null) {
            fileStoragePersistWithUrlGetter.delete(oldCv, FilesTypesDirectories.UserProfileCv);
        }
    }

    private String generateFileName() {
        return user.getId() + RandomString.generateRandomString(5);
    }
}
