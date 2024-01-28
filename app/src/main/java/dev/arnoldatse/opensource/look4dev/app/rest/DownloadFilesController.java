package dev.arnoldatse.opensource.look4dev.app.rest;

import dev.arnoldatse.opensource.look4dev.app.services.fileStorage.DownloadFileService;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/storage")
public class DownloadFilesController {
    private final DownloadFileService downloadFileService;

    @Autowired
    DownloadFilesController(DownloadFileService downloadFileService) {
        this.downloadFileService = downloadFileService;
    }

    private ResponseEntity<Resource> returnFile(Resource resource){
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

    @GetMapping("/user-profile-picture/{fileName:.+}")
    public ResponseEntity<Resource> downloadUserProfilePicture(@PathVariable String fileName) throws NotFoundException {
        return returnFile(downloadFileService.downloadUserProfilePicture(fileName));
    }

    @GetMapping("/user-cv/{fileName:.+}")
    public ResponseEntity<Resource> downloadUserProfileCv(@PathVariable String fileName) throws NotFoundException {
        return returnFile(downloadFileService.downloadUserProfileCv(fileName));

    }
}
