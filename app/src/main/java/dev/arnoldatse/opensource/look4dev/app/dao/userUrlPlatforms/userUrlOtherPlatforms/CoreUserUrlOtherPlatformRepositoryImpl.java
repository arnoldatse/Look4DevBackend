package dev.arnoldatse.opensource.look4dev.app.dao.userUrlPlatforms.userUrlOtherPlatforms;

import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.mappers.MapperUserUrlOtherPlatformToCoreUserUrlOtherPlatform;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoreUserUrlOtherPlatformRepositoryImpl implements dev.arnoldatse.opensource.look4dev.core.users.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatformRepository {
    @Autowired
    private UserUrlOtherPlatformRepository userUrlOtherPlatformRepository;

    @Override
    public List<dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform> findAllByUserId(String userId) {
        List<UserUrlOtherPlatform> userUrlOtherPlatforms = userUrlOtherPlatformRepository.findAllByUserId(userId);
        return userUrlOtherPlatforms
                .stream()
                .map(userUrlOtherPlatform -> new MapperUserUrlOtherPlatformToCoreUserUrlOtherPlatform(userUrlOtherPlatform)
                        .mapToUserUrlOtherPlatform())
                .toList();
    }

    @Override
    @Transactional
    public void deleteAllByUserId(String userId) {
        userUrlOtherPlatformRepository.deleteByUserId(userId);
    }
}
