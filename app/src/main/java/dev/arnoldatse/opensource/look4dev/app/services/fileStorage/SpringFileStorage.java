package dev.arnoldatse.opensource.look4dev.app.services.fileStorage;

import dev.arnoldatse.opensource.look4dev.core.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.adapters.FileStorageGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.adapters.FileStoragePersistAndUrlGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.enums.FilesDirectories;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.enums.FilesTypesUrlsParts;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SpringFileStorage implements FileStoragePersistAndUrlGetterAdapter<MultipartFile>, FileStorageGetterAdapter<Resource> {
    private final Path rootLocation;
    private final String appBaseUrl;

    public SpringFileStorage(String rootLocation, String appBaseUrl) {
        this.rootLocation = Paths.get(rootLocation);
        this.appBaseUrl = appBaseUrl;
    }

    @Override
    public void store(MultipartFile file, String fileName, String fileExtension, FilesDirectories dir) throws FailedToStoreFileException {
        if (file != null && !file.isEmpty()) {
            Path destinationFile = rootLocation.resolve(
                    Paths.get(dir.getValue(), fileName + "." + fileExtension)
            ).normalize().toAbsolutePath();
            try {
                InputStream inputStream = file.getInputStream();
                Files.createDirectories(destinationFile.getParent());
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                throw new FailedToStoreFileException("Failed to save file in storage: " + e.getMessage());
            }
        } else {
            throw new FailedToStoreFileException("Do not have file to store or file is empty");
        }
    }

    @Override
    public void delete(String fileName, FilesDirectories dir) {
        FileSystemUtils.deleteRecursively(rootLocation.resolve(Paths.get(dir.getValue(), fileName)).toFile());
    }

    @Override
    public Resource get(String fileName, FilesDirectories dir) throws NotFoundException {
        Path file = rootLocation.resolve(Paths.get(dir.getValue(), fileName));
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            throw new NotFoundException("Failed to get file");
        } catch (MalformedURLException e) {
            throw new NotFoundException("Failed to get file: " + e.getMessage());
        }
    }

    @Override
    public String getUrl(FilesTypesUrlsParts filesTypesUrlsParts, String fileName) throws NotFoundException {
        if (fileName != null && !fileName.isEmpty()) {
            return appBaseUrl + "/storage" + filesTypesUrlsParts.getValue() + fileName;
        }
        throw new NotFoundException("File Not found");
    }
}
