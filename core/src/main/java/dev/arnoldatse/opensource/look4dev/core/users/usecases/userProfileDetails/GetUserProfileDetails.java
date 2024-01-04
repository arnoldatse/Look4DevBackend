package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails.MapperUserToUserProfileDetailsResponse;
import dev.arnoldatse.opensource.look4dev.core.http.httpError.exceptions.NotFoundHttpErrorException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;

import java.util.Optional;

public class GetUserProfileDetails {
    private final UserRepository userRepository;
    private final String userId;

    public GetUserProfileDetails(UserRepository userRepository, String userId) {
        this.userRepository = userRepository;
        this.userId = userId;
    }

    public UserProfileDetailsResponseDto execute() throws NotFoundHttpErrorException {
        Optional<User> userOptional = userRepository.findFirstByEmailOrPseudo(userId);
        if(userOptional.isPresent()){
            return new MapperUserToUserProfileDetailsResponse(userOptional.get()).mapFromUser();
        }
        throw  new NotFoundHttpErrorException("User not found");
    }
}
