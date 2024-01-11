package dev.arnoldatse.opensource.look4dev.app.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.UserUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.UserUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatformRepository;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.UserTokenInfosDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UpdateUserProfileDetailsRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails.GetUserProfileDetails;
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

    public UserProfileDetailsResponseDto get() throws NotFoundHttpErrorException {
        return new GetUserProfileDetails(userRepository, getAuthenticatedUserId()).execute();
    }

    public UserProfileDetailsResponseDto update(UpdateUserProfileDetailsRequestDto updateUserProfileDetailsRequestDto) throws NotFoundHttpErrorException {
        return new UpdateUserProfileDetails(
                updateUserProfileDetailsRequestDto,
                getAuthenticatedUserId(),
                userRepository,
                userUrlOtherPlatformRepository,
                userUrlSupportedPlatformRepository
        ).execute();
    }

    private String getAuthenticatedUserId(){
        UserTokenInfosDto userTokenInfos = (UserTokenInfosDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userTokenInfos.id();
    }
}
