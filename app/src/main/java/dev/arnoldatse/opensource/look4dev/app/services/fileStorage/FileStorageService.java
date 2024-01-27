package dev.arnoldatse.opensource.look4dev.app.services.fileStorage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {
    @Value("${app.baseurl}")
    private String appBaseUrl;
    @Value("${app.storage.rootLocation}")
    private String appStorageRootLocation;

    private Path getStorageRootPath(){
        return Paths.get(appStorageRootLocation);
    }

    public SpringFileStorage getInstance(){
        return new SpringFileStorage(appStorageRootLocation, appBaseUrl);
    }
}
