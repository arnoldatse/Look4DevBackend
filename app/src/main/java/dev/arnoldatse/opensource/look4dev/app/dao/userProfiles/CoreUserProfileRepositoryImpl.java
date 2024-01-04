package dev.arnoldatse.opensource.look4dev.app.dao.userProfiles;

import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.mappers.MapperUserProfileToCoreUserProfile;
import dev.arnoldatse.opensource.look4dev.app.entities.userProfile.UserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.mappers.MapperToUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CoreUserProfileRepositoryImpl implements dev.arnoldatse.opensource.look4dev.core.userProfile.UserProfileRepository {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile findById(int id) {
        return null;
    }

    @Override
    public List<dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile> findAllById(int[] ids) {
        List<Integer> listIds = Arrays.stream(ids).boxed().collect(Collectors.toList());
        Iterable<UserProfile> iterableUserProfiles = userProfileRepository.findAllById(listIds);
        List<dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfile> userProfileSimples = new ArrayList<>();


        iterableUserProfiles.forEach(userProfile ->{
            MapperToUserProfile mapperUserProfileToCoreUserProfileSimple = new MapperUserProfileToCoreUserProfile(userProfile);
            userProfileSimples.add(mapperUserProfileToCoreUserProfileSimple.mapToUserProfile());
        });

        return userProfileSimples;
    }
}
