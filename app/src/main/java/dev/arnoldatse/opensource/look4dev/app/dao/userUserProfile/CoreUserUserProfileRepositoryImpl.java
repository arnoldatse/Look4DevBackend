package dev.arnoldatse.opensource.look4dev.app.dao.userUserProfile;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoreUserUserProfileRepositoryImpl implements dev.arnoldatse.opensource.look4dev.core.users.userProfileDetails.UserUserProfileRepository {
    @Autowired
    UserUserProfileRepository userUserProfileRepository;

    @Override
    @Transactional
    public void deleteAllByUserId(String userId) {
        userUserProfileRepository.deleteByUserId(userId);
    }
}
