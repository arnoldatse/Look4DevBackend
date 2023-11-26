package dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers;

public interface UserProfileMapper<UserProfile, MatchUser> {
    /**
     * Map the match UserProfileSimple to the core UserProfile and return it
     * @return User
     */
    public UserProfile mapToUserProfile();

    /**
     * Map core UserProfileSimple to the match UserProfile and return it
     * @return MatchUser
     */
    public MatchUser mapToMatchUserProfile();
}
