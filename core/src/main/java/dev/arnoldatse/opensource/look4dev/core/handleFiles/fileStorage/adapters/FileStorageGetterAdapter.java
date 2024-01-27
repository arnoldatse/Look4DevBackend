package dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters;

import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesDirectories;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;

public interface FileStorageGetterAdapter<T> {
    T get(String fileName, FilesDirectories dir) throws NotFoundException;
}
