package dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters;

import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesUrlsParts;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;

public interface FileStorageUrlGetterAdapter {
    String getUrl(FilesTypesUrlsParts filesTypesUrlsParts, String fileName) throws NotFoundException;
}
