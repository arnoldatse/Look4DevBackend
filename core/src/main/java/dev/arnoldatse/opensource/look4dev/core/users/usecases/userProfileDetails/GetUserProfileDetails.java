package dev.arnoldatse.opensource.look4dev.core.users.usecases.userProfileDetails;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.dtos.userProfileDetailsDto.UserProfileDetailsResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.userProfileDetails.MapperUserToUserProfileDetailsResponse;
import dev.arnoldatse.opensource.look4dev.core.fileStorage.FileStorage;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.NotFoundException;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;

import java.util.Optional;

public class GetUserProfileDetails {
    private final UserRepository userRepository;
    private final String userId;
    private final FileStorage fileStorage;

    public GetUserProfileDetails(UserRepository userRepository, String userId, FileStorage fileStorage) {
        this.userRepository = userRepository;
        this.userId = userId;
        this.fileStorage = fileStorage;
    }

    public UserProfileDetailsResponseDto execute() throws NotFoundException {
        Optional<User> userOptional = userRepository.findFirstById(userId);
        if(userOptional.isPresent()){
            return new MapperUserToUserProfileDetailsResponse(userOptional.get(), fileStorage).mapFromUser();
        }
        throw new NotFoundException("User not found");
    }
}
