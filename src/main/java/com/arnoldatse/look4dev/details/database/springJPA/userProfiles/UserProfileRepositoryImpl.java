package com.arnoldatse.look4dev.details.database.springJPA.userProfiles;

import com.arnoldatse.look4dev.app.entities.UserProfile;
import com.arnoldatse.look4dev.core.entities.userProfile.UserProfileSimple;
import com.arnoldatse.look4dev.core.userProfile.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserProfileRepositoryImpl implements UserProfileRepository {
    @Autowired
    private UserProfileJPARepository userProfileJPARepository;

    @Override
    public UserProfileSimple findById(int id) {
        return null;
    }

    @Override
    public List<UserProfileSimple> findAllById(int[] ids) {
        List<Integer> listIds = Arrays.stream(ids).boxed().collect(Collectors.toList());
        Iterable<UserProfile> iterableUserProfiles = userProfileJPARepository.findAllById(listIds);
        List<UserProfileSimple> userProfileSimples = new ArrayList<>();


        iterableUserProfiles.forEach(userProfile ->{
            UserProfileJPAUserProfileSimpleMapper userProfileJPAMapper = new UserProfileJPAUserProfileSimpleMapper(new UserProfileSimple(), userProfile);
            userProfileSimples.add(userProfileJPAMapper.mapToUserProfile());
        });

        return userProfileSimples;
    }
}
