package dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.userExperienceProjects.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.UserExperienceProject;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.dtos.UserExperienceProjectRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.mappers.MapperUserExperienceProjectRequestToUserExperienceProject;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProjectScreenshot.UserExperienceProjectScreenshotRequestFile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters.FileStoragePersistAndUrlGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.FileExtensionNotSupportedException;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.userExperienceProjects.UserExperienceProjectRepository;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.userExperienceProjects.UserExperienceProjectScreenshotRepository;
import dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences.userExperienceProjects.UserExperiencesAndExperienceProjectsUseCases;

import java.util.List;

public class AddUserExperienceProject<ScreenShotFile> extends UserExperiencesAndExperienceProjectsUseCases<ScreenShotFile> {
    private final UserExperienceProjectRequestDto userExperienceProjectRequest;
    private final UserExperienceProjectRepository userExperienceProjectRepository;
    protected AddUserExperienceProject(List<UserProfileName> userProfilesNames,
                                       UserExperienceProjectRequestDto userExperienceProjectRequest,
                                       UserExperienceProjectRepository userExperienceProjectRepository,
                                       UserExperienceProjectScreenshotRequestFile<ScreenShotFile>[] screenShots,
                                       FileStoragePersistAndUrlGetterAdapter<ScreenShotFile> fileStoragePersistAndUrlGetter,
                                       UserExperienceProjectScreenshotRepository userExperienceProjectScreenshotRepository) {
        super(userProfilesNames,
                screenShots,
                fileStoragePersistAndUrlGetter,
                userExperienceProjectScreenshotRepository);
        this.userExperienceProjectRequest = userExperienceProjectRequest;
        this.userExperienceProjectRepository = userExperienceProjectRepository;
    }

    public UserExperienceProject execute() throws ForbiddenException, FailedToStoreFileException, FileExtensionNotSupportedException {
        checkUserExperiencesAndSkillsActionsAuthorized();
        checkScreenShotsExtensions();

        UserExperienceProject savedUserExperienceProject = saveUserExperienceProject();

        List<String> savedScreenshots = saveScreenShots(savedUserExperienceProject);

        savedUserExperienceProject.setScreenshots(savedScreenshots.toArray(new String[0]));
        return savedUserExperienceProject;
    }

    private UserExperienceProject saveUserExperienceProject() {
        UserExperienceProject userExperienceProject = new MapperUserExperienceProjectRequestToUserExperienceProject(userExperienceProjectRequest)
                .mapToUserExperienceProject();
        return userExperienceProjectRepository.save(userExperienceProject);
    }
}
