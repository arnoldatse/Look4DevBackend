package dev.arnoldatse.opensource.look4dev.app.services.fileStorage;

import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesDirectories;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class DownloadFileService {
    private final FileStorageService fileStorageService;

    @Autowired
    public DownloadFileService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    public Resource downloadUserProfilePicture(String fileName) throws NotFoundException {
        return fileStorageService.getInstance().get(fileName, FilesTypesDirectories.UserProfilePicture);
    }
    public Resource downloadUserProfileCv(String fileName) throws NotFoundException {
        return fileStorageService.getInstance().get(fileName, FilesTypesDirectories.UserProfileCv);
    }
}
