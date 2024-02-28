package dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.userExperienceProjects;

import java.util.List;

public interface UserExperienceProjectScreenshotRepository {
    List<String> findAllByExperienceProjectId(String userExperienceProjectId);
    List<String> addAll(String userExperienceProjectId, List<String> screenshot);
    String add(String userExperienceProjectId, String screenshot);
    List<String> removeAllByExperienceProjectId(String userExperienceProjectId);
    List<String> remove(String screenshotId);
}
