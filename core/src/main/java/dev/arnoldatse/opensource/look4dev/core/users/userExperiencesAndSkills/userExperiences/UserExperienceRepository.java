package dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperience.UserExperience;

import java.util.List;

public interface UserExperienceRepository {
    List<UserExperience> findAllByUserId(String userId);
    UserExperience findByIdAndUserid(String userId, String userExperienceId);
    UserExperience save(UserExperience userExperience);
    UserExperience update(UserExperience userExperience);
    void removeByIdAndUserId(String userId, String userExperienceId);
}
