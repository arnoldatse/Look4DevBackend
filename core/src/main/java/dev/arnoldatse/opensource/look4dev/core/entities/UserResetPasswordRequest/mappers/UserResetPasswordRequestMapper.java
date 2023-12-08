package dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.mappers;

public interface UserResetPasswordRequestMapper <UserResetPasswordRequest, MatchUserResetPasswordRequest>{
    /**
     * Map the match UserResetPasswordRequest to the core UserResetPasswordRequest and return it
     * @return User
     */
    UserResetPasswordRequest mapToUserResetPasswordRequest();

    /**
     * Map core UserResetPasswordRequest to the match UserResetPasswordRequest and return it
     * @return MatchUser
     */
    MatchUserResetPasswordRequest mapToMatchUserResetPasswordRequest();
}
