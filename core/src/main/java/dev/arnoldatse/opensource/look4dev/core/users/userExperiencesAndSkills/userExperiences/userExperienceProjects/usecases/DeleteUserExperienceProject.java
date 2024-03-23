package dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.userExperienceProjects.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.UserExperienceProject;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters.FileStorageDeleteAdapter;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesDirectories;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.UserExperiencesAndSkillsUseCases;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.userExperienceProjects.UserExperienceProjectRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.userExperienceProjects.UserExperienceProjectScreenshotRepository;

import java.util.List;

public class DeleteUserExperienceProject extends UserExperiencesAndSkillsUseCases {
    private final String userId;
    private final String userExperienceProjectId;
    private final FileStorageDeleteAdapter fileStorageDeleteAdapter;
    private final UserExperienceProjectRepository userExperienceProjectRepository;
    private final UserExperienceProjectScreenshotRepository userExperienceProjectScreenshotRepository;

    public DeleteUserExperienceProject(String userId,
                                       List<UserProfileName> userProfilesNames,
                                       String userExperienceProjectId,
                                       FileStorageDeleteAdapter fileStorageDeleteAdapter,
                                       UserExperienceProjectRepository userExperienceProjectRepository,
                                       UserExperienceProjectScreenshotRepository userExperienceProjectScreenshotRepository) {
        super(userProfilesNames);
        this.userId = userId;
        this.userExperienceProjectId = userExperienceProjectId;
        this.fileStorageDeleteAdapter = fileStorageDeleteAdapter;
        this.userExperienceProjectRepository = userExperienceProjectRepository;
        this.userExperienceProjectScreenshotRepository = userExperienceProjectScreenshotRepository;
    }

    public List<UserExperienceProject> execute() throws ForbiddenException {
        checkUserExperiencesAndSkillsActionsAuthorized();
        deleteScreenshots();
        UserExperienceProject userExperienceProject = userExperienceProjectRepository.findByIdAndUserId(userExperienceProjectId, userId);
        userExperienceProjectRepository.removeByUserExperienceProjectIdAndUserId(userExperienceProjectId, userId);
        return userExperienceProjectRepository.findByUserExperienceIdAndUserId(userExperienceProject.getUserExperience().getId(), userId);
    }

    private void deleteScreenshots() {
        List<String> screenshots = userExperienceProjectScreenshotRepository.findAllByExperienceProjectId(userExperienceProjectId);
        screenshots.forEach(screenshot ->
                fileStorageDeleteAdapter.delete(
                        screenshot,
                        FilesTypesDirectories.UserProjectScreenshot));
        userExperienceProjectScreenshotRepository.removeAllByExperienceProjectId(userExperienceProjectId);
    }
}
