package dev.arnoldatse.opensource.look4dev.app.services;

import dev.arnoldatse.opensource.look4dev.core.fileStorage.FileStorageAdapter;
import dev.arnoldatse.opensource.look4dev.details.fileStorage.StandardFileStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileStorageService {
    @Value("${app.baseurl}")
    private String appBaseUrl;
    public FileStorageAdapter getInstance(){
        return new StandardFileStorage(appBaseUrl);
    }
}
