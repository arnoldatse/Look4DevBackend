package dev.arnoldatse.opensource.look4dev.core.users.userUrlPlatform.userUrlOtherPlatform;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform;

import java.util.List;

public interface UserUrlOtherPlatformRepository {
    List<UserUrlOtherPlatform> findAllByUserId(String userId);
    void deleteAllByUserId(String userId);
}
