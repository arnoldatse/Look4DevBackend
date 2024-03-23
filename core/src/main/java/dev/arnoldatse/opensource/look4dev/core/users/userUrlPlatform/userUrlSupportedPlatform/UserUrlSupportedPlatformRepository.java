package dev.arnoldatse.opensource.look4dev.core.users.userUrlPlatform.userUrlSupportedPlatform;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform;

import java.util.List;

public interface UserUrlSupportedPlatformRepository {
    List<UserUrlSupportedPlatform> findAllByUserId(String userId);
    void deleteAllByUserId(String userId);
}
