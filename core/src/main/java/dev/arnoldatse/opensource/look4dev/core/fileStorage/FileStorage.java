package dev.arnoldatse.opensource.look4dev.core.fileStorage;

import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;

public interface FileStorage {
    String rootDir = "/";
    void store(Object file, String fileName, String fileExtension, FilesDirectories dir) throws FailToStoreException;
    void get(String fileName, FilesDirectories dir) throws NotFoundException;
    String getUrl(FilesTypesUrlsParts filesTypesUrlsParts, String fileName) throws NotFoundException;
}
