package dev.arnoldatse.opensource.look4dev.core.UserUrlPlatform.userUrlSupportedPlatform;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform;

import java.util.List;

public interface UserUrlSupportedPlatformRepository {
    public List<UserUrlSupportedPlatform> findAllByUserId(String userId);
    public void deleteAllByUserId(String userId);
}
