package dev.arnoldatse.opensource.look4dev.app.users.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.app.services.AuthenticatedUserService;
import dev.arnoldatse.opensource.look4dev.app.services.fileStorage.FileStorageService;
import dev.arnoldatse.opensource.look4dev.core.users.userProfileDetails.usecases.GetUserProfileDetails;
import dev.arnoldatse.opensource.look4dev.core.users.userProfileDetails.usecases.UpdateUserPassword;
import dev.arnoldatse.opensource.look4dev.core.users.userProfileDetails.usecases.UpdateUserProfileDetails;
import dev.arnoldatse.opensource.look4dev.core.users.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.PasswordUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsFileUrlResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.FileExtensionNotSupportedException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.RepositoryException;
import dev.arnoldatse.opensource.look4dev.core.users.UserPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userProfileDetails.UserUserProfileRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userProfileDetails.profileCv.usecases.UpdateUserProfileCv;
import dev.arnoldatse.opensource.look4dev.core.users.userProfileDetails.profilePicture.usecases.UpdateUserProfilePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
public class UserProfileDetailsService {
    private final UserRepository userRepository;
    private final UserUrlOtherPlatformRepository userUrlOtherPlatformRepository;
    private final UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository;
    private final UserUserProfileRepository userUserProfileRepository;
    private final UserPasswordEncoder userPasswordEncoder;
    private final FileStorageService fileStorageService;
    private final AuthenticatedUserService authenticatedUserService;

    @Autowired
    public UserProfileDetailsService(UserRepository userRepository, UserUrlOtherPlatformRepository userUrlOtherPlatformRepository, UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository, UserUserProfileRepository userUserProfileRepository, UserPasswordEncoder userPasswordEncoder, FileStorageService fileStorageService, AuthenticatedUserService authenticatedUserService) {
        this.userRepository = userRepository;
        this.userUrlOtherPlatformRepository = userUrlOtherPlatformRepository;
        this.userUrlSupportedPlatformRepository = userUrlSupportedPlatformRepository;
        this.userUserProfileRepository = userUserProfileRepository;
        this.userPasswordEncoder = userPasswordEncoder;
        this.fileStorageService = fileStorageService;
        this.authenticatedUserService = authenticatedUserService;
    }

    public UserProfileDetailsResponseDto get() {
        return new GetUserProfileDetails(
                authenticatedUserService.getAuthenticatedUser(),
                userUrlOtherPlatformRepository,
                userUrlSupportedPlatformRepository,
                fileStorageService.getInstance()
        ).execute();
    }

    public UserProfileDetailsResponseDto update(UserProfileDetailsUpdateRequestDto userProfileDetailsUpdateRequestDto) throws NotFoundException, RepositoryException {

        return new UpdateUserProfileDetails(
                userProfileDetailsUpdateRequestDto,
                authenticatedUserService.getAuthenticatedUser(),
                userRepository,
                userUrlOtherPlatformRepository,
                userUrlSupportedPlatformRepository,
                userUserProfileRepository,
                fileStorageService.getInstance()
        ).execute();
    }

    public DefaultHttpResponse updatePassword(PasswordUpdateRequestDto passwordUpdateRequestDto) throws Exception {
        return new UpdateUserPassword(
                authenticatedUserService.getAuthenticatedUser(),
                passwordUpdateRequestDto,
                userRepository,
                userPasswordEncoder
        ).execute();
    }

    public UserProfileDetailsFileUrlResponseDto updatePicture(MultipartFile picture) throws FailedToStoreFileException, NotFoundException, FileExtensionNotSupportedException {
        return new UpdateUserProfilePicture<>(
                authenticatedUserService.getAuthenticatedUser(),
                userRepository,
                fileStorageService.getInstance(),
                picture,
                Objects.requireNonNull(picture.getContentType()).split("/")[1]
        ).execute();
    }

    public UserProfileDetailsFileUrlResponseDto updateCv(MultipartFile cv) throws FailedToStoreFileException, NotFoundException, FileExtensionNotSupportedException {
        return new UpdateUserProfileCv<>(
                authenticatedUserService.getAuthenticatedUser(),
                userRepository,
                fileStorageService.getInstance(),
                cv,
                Objects.requireNonNull(cv.getContentType()).split("/")[1]
        ).execute();
    }
}
