package com.arnoldatse.look4dev.core.entities.user.mappers;

public interface UserMapper<User, MatchUser> {
    /**
     * Map the match User to the core User and return it
     * @return User
     */
    public User mapToUser();

    /**
     * Map core User to the match User and return it
     * @return MatchUser
     */
    public MatchUser mapToMatchUser();
}
