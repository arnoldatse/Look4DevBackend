package dev.arnoldatse.opensource.look4dev.app.dao.userUrlPlatforms.userUrlSupportedPlatforms;


import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.mappers.MapperUserUrlSupportedPlatformToCoreUserUrlSupportedPlatform;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoreUserSupportedPlatformRepositoryImpl implements dev.arnoldatse.opensource.look4dev.core.users.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatformRepository {
    @Autowired
    UserUrlSupportedPlatformRepository userUrlSupportedPlatformRepository;

    @Override
    public List<dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform> findAllByUserId(String userId) {
        List<UserUrlSupportedPlatform> userUrlSupportedPlatforms = userUrlSupportedPlatformRepository.findAllByUserId(userId);
        return userUrlSupportedPlatforms
                .stream()
                .map(userUrlSupportedPlatform -> new MapperUserUrlSupportedPlatformToCoreUserUrlSupportedPlatform(userUrlSupportedPlatform)
                        .mapToUserUrlSupportedPlatform())
                .toList();
    }

    @Override
    @Transactional
    public void deleteAllByUserId(String userId) {
        userUrlSupportedPlatformRepository.deleteByUserId(userId);
    }
}
