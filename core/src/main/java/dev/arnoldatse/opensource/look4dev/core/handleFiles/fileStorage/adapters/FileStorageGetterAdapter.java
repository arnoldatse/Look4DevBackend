package dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters;

import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesDirectories;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;

public interface FileStorageGetterAdapter<File> {
    File get(String fileName, FilesTypesDirectories dir) throws NotFoundException;
}
