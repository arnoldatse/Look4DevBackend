package dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters;

import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesDirectories;

public interface FileStoragePersistAdapter<File> extends FileStorageDeleteAdapter {
    void store(File file, String fileName, String fileExtension, FilesTypesDirectories dir) throws FailedToStoreFileException;
}
