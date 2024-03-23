package dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.userExperienceProjects;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.UserExperienceProject;

import java.util.List;

public interface UserExperienceProjectRepository {
    UserExperienceProject save(UserExperienceProject userExperienceProject);
    List<UserExperienceProject> saveAll(List<UserExperienceProject> userExperienceProjects);
    UserExperienceProject update(UserExperienceProject userExperienceProject);
    UserExperienceProject findByIdAndUserId(String userExperienceProjectId, String userId);
    List<UserExperienceProject> findByUserExperienceIdAndUserId(String userExperienceId, String userId);
    void removeByUserExperienceProjectIdAndUserId(String userExperienceProjectId, String userId);
}
