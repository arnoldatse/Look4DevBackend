package dev.arnoldatse.opensource.look4dev.app.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.app.services.FileStorageService;
import dev.arnoldatse.opensource.look4dev.core.UserUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.UserUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.PasswordUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsUpdateRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.DefaultHttpResponse;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.RepositoryException;
import dev.arnoldatse.opensource.look4dev.core.users.UserPasswordEncoder;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.UserUserProfileRepository;
import dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails.GetUserProfileDetails;
import dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails.UpdateUserPassword;
import dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails.UpdateUserProfileDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserUrlOtherPlatformRepository userUrlOtherPlatformRepository;
    @Autowired
    UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository;
    @Autowired
    UserUserProfileRepository userUserProfileRepository;
    @Autowired
    UserPasswordEncoder userPasswordEncoder;
    @Autowired
    FileStorageService fileStorageService;

    public UserProfileDetailsResponseDto get() throws NotFoundException {
        return new GetUserProfileDetails(userRepository, getAuthenticatedUserId(), fileStorageService.getInstance()).execute();
    }

    public UserProfileDetailsResponseDto update(UserProfileDetailsUpdateRequestDto userProfileDetailsUpdateRequestDto) throws NotFoundException, RepositoryException {

        return new UpdateUserProfileDetails(
                userProfileDetailsUpdateRequestDto,
                getAuthenticatedUserId(),
                userRepository,
                userUrlOtherPlatformRepository,
                userUrlSupportedPlatformRepository,
                userUserProfileRepository,
                fileStorageService.getInstance()
        ).execute();
    }

    public DefaultHttpResponse updatePassword(PasswordUpdateRequestDto passwordUpdateRequestDto) throws Exception {
        return new UpdateUserPassword(
                getAuthenticatedUserId(),
                passwordUpdateRequestDto,
                userRepository,
                userPasswordEncoder
        ).execute();
    }

    private String getAuthenticatedUserId(){
        UserTokenInfosDto userTokenInfos = (UserTokenInfosDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userTokenInfos.id();
    }
}
