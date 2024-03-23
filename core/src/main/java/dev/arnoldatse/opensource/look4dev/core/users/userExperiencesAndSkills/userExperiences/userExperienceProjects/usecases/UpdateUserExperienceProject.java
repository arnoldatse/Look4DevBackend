package dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.userExperienceProjects.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.UserExperienceProject;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.dtos.UserExperienceProjectRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.mappers.MapperUserExperienceProjectRequestToUserExperienceProject;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProjectScreenshot.UserExperienceProjectScreenshotRequestFile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters.FileStoragePersistAndUrlGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.FileExtensionNotSupportedException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.userExperienceProjects.UserExperienceProjectRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.userExperienceProjects.UserExperienceProjectScreenshotRepository;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.userExperienceProjects.UserExperiencesAndExperienceProjectsUseCases;

import java.util.List;

public class UpdateUserExperienceProject<ScreenShotFile> extends UserExperiencesAndExperienceProjectsUseCases<ScreenShotFile> {
    private final String userExperienceProjectId;
    private final UserExperienceProjectRequestDto userExperienceProjectRequest;
    private final UserExperienceProjectRepository userExperienceProjectRepository;
    protected UpdateUserExperienceProject(List<UserProfileName> userProfilesNames,
                                          String userExperienceProjectId,
                                          UserExperienceProjectRequestDto userExperienceProjectRequest,
                                          UserExperienceProjectRepository userExperienceProjectRepository,
                                          UserExperienceProjectScreenshotRequestFile<ScreenShotFile>[] screenShots,
                                          FileStoragePersistAndUrlGetterAdapter<ScreenShotFile> fileStoragePersistAndUrlGetter,
                                          UserExperienceProjectScreenshotRepository userExperienceProjectScreenshotRepository) {
        super(userProfilesNames,
                screenShots,
                fileStoragePersistAndUrlGetter,
                userExperienceProjectScreenshotRepository);
        this.userExperienceProjectId = userExperienceProjectId;
        this.userExperienceProjectRequest = userExperienceProjectRequest;
        this.userExperienceProjectRepository = userExperienceProjectRepository;
    }

    public UserExperienceProject execute() throws ForbiddenException, FailedToStoreFileException, FileExtensionNotSupportedException {
        checkUserExperiencesAndSkillsActionsAuthorized();
        checkScreenShotsExtensions();

        UserExperienceProject updatedUserExperienceProject = updateUserExperienceProject();

        List<String> savedScreenshots = saveScreenShots(updatedUserExperienceProject);

        updatedUserExperienceProject.setScreenshots(savedScreenshots.toArray(new String[0]));
        return updatedUserExperienceProject;
    }

    private UserExperienceProject updateUserExperienceProject() {
        UserExperienceProject userExperienceProject = new MapperUserExperienceProjectRequestToUserExperienceProject(userExperienceProjectRequest)
                .mapToUserExperienceProject();
        userExperienceProject.setId(userExperienceProjectId);
        return userExperienceProjectRepository.update(userExperienceProject);
    }
}
