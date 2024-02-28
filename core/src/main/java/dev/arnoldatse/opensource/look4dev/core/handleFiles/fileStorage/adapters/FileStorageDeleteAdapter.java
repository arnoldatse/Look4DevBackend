package dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters;

import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesDirectories;

public interface FileStorageDeleteAdapter {
    void delete(String fileName, FilesTypesDirectories dir);
}
