package dev.arnoldatse.opensource.look4dev.app.rest;

import dev.arnoldatse.opensource.look4dev.app.userProfileDetails.UserProfileDetailsService;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UpdateUserProfileDetailsRequestDto;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileDetailsController {
    @Autowired
    UserProfileDetailsService userProfileDetailsService;

    @GetMapping("/get")
    public UserProfileDetailsResponseDto get() throws NotFoundHttpErrorException {
        return userProfileDetailsService.get();
    }

    @PatchMapping("/update")
    public UserProfileDetailsResponseDto update(@RequestBody UpdateUserProfileDetailsRequestDto userUpdateProfileDetailsRequest) throws NotFoundHttpErrorException {
        return userProfileDetailsService.update(userUpdateProfileDetailsRequest);
    }
}
