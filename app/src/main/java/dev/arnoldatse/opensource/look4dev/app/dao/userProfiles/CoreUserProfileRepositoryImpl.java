package dev.arnoldatse.opensource.look4dev.app.dao.userProfiles;

import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.mappers.MapperUserProfileToCoreUserProfile;
import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperToUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CoreUserProfileRepositoryImpl implements dev.arnoldatse.opensource.look4dev.core.userProfile.UserProfileRepository {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public Optional<dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile> findById(int id) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(id);
        return optionalUserProfile.map(userProfile -> new MapperUserProfileToCoreUserProfile(userProfile).mapToUserProfile());
    }

    @Override
    public List<dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile> findAllById(int[] ids) {
        List<Integer> listIds = Arrays.stream(ids).boxed().collect(Collectors.toList());
        Iterable<UserProfile> iterableUserProfiles = userProfileRepository.findAllById(listIds);

        List<dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile> coreUserProfiles = new ArrayList<>();
        iterableUserProfiles.forEach(userProfile ->{
            MapperToUserProfile mapperUserProfileToCoreUserProfileSimple = new MapperUserProfileToCoreUserProfile(userProfile);
            coreUserProfiles.add(mapperUserProfileToCoreUserProfileSimple.mapToUserProfile());
        });

        return coreUserProfiles;
    }
}
