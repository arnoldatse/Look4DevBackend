package dev.arnoldatse.opensource.look4dev.app.rest;

import dev.arnoldatse.opensource.look4dev.app.userProfileDetails.UserProfileDetailsService;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.PasswordUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsFileUrlResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.FileExtensionNotSupportedException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profile")
public class UserProfileDetailsController {
    @Autowired
    UserProfileDetailsService userProfileDetailsService;

    @GetMapping("/get")
    public UserProfileDetailsResponseDto get() throws NotFoundException {
        return userProfileDetailsService.get();
    }

    @PatchMapping("/update")
    public UserProfileDetailsResponseDto update(@RequestBody UserProfileDetailsUpdateRequestDto userUpdateProfileDetailsRequest) throws NotFoundException, RepositoryException {
        return userProfileDetailsService.update(userUpdateProfileDetailsRequest);
    }
    @PatchMapping("/update-password")
    public DefaultHttpResponse update(@RequestBody PasswordUpdateRequestDto passwordUpdateRequestDto) throws Exception {
        return userProfileDetailsService.updatePassword(passwordUpdateRequestDto);
    }

    @PostMapping("/update-picture")
    public UserProfileDetailsFileUrlResponseDto updatePicture(@RequestParam("picture") MultipartFile picture) throws FailedToStoreFileException, NotFoundException, FileExtensionNotSupportedException {
        return userProfileDetailsService.updatePicture(picture);
    }

    @PostMapping("/update-cv")
    public UserProfileDetailsFileUrlResponseDto updateCv(@RequestParam("cv") MultipartFile cv) throws FailedToStoreFileException, NotFoundException, FileExtensionNotSupportedException {
        return userProfileDetailsService.updateCv(cv);
    }
}
