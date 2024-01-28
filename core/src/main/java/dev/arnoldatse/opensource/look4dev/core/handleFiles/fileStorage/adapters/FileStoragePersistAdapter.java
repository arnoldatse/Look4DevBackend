package dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters;

import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesDirectories;

public interface FileStoragePersistAdapter<T> {
    void store(T file, String fileName, String fileExtension, FilesTypesDirectories dir) throws FailedToStoreFileException;
    void delete(String fileName, FilesTypesDirectories dir);
}
