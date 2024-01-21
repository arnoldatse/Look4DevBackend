package dev.arnoldatse.opensource.look4dev.details.fileStorage;

import dev.arnoldatse.opensource.look4dev.core.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FileStorage;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FilesDirectories;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FilesTypesUrlsParts;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;

public class StandardFileStorage implements FileStorage {
    private final String appBaseUrl;

    public StandardFileStorage(String appBaseUrl) {
        this.appBaseUrl = appBaseUrl;
    }

    @Override
    public void store(Object file, String fileName, String fileExtension, FilesDirectories dir) throws FailedToStoreFileException {

    }

    @Override
    public void get(String fileName, FilesDirectories dir) throws NotFoundException {

    }

    @Override
    public String getUrl(FilesTypesUrlsParts filesTypesUrlsParts, String fileName) throws NotFoundException {
        if(fileName!=null && !fileName.isEmpty()){
            return appBaseUrl+filesTypesUrlsParts.getValue()+fileName;
        }
        throw new NotFoundException("File Not found");
    }
}
