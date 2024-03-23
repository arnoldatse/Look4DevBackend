package dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userExperiences.userExperienceProjects;

import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.UserExperienceProject;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProjectScreenshot.UserExperienceProjectScreenshotRequestFile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.CheckSupportedFileExtension;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.FileExtensions;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.FailedToStoreFileException;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.adapters.FileStoragePersistAndUrlGetterAdapter;
import dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums.FilesTypesDirectories;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.FileExtensionNotSupportedException;
import dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.UserExperiencesAndSkillsUseCases;
import dev.arnoldatse.opensource.look4dev.core.utils.RandomString;

import java.util.ArrayList;
import java.util.List;

public abstract class UserExperiencesAndExperienceProjectsUseCases<ScreenShotFile> extends UserExperiencesAndSkillsUseCases {
    private final UserExperienceProjectScreenshotRequestFile<ScreenShotFile>[] screenShots;
    private final FileStoragePersistAndUrlGetterAdapter<ScreenShotFile> fileStoragePersistAndUrlGetter;
    private final UserExperienceProjectScreenshotRepository userExperienceProjectScreenshotRepository;
    protected UserExperiencesAndExperienceProjectsUseCases(List<UserProfileName> userProfilesNames,
                                                           UserExperienceProjectScreenshotRequestFile<ScreenShotFile>[] screenShots,
                                                           FileStoragePersistAndUrlGetterAdapter<ScreenShotFile> fileStoragePersistAndUrlGetter,
                                                           UserExperienceProjectScreenshotRepository userExperienceProjectScreenshotRepository) {
        super(userProfilesNames);
        this.screenShots = screenShots;
        this.fileStoragePersistAndUrlGetter = fileStoragePersistAndUrlGetter;
        this.userExperienceProjectScreenshotRepository = userExperienceProjectScreenshotRepository;
    }

    protected List<String> saveScreenShots(UserExperienceProject userExperienceProject) throws FailedToStoreFileException {
        return saveScreenShotsInDatabase(userExperienceProject.getId(), storeScreenShots(userExperienceProject));
    }

    protected List<String> saveScreenShotsInDatabase(String userExperienceProjectId, List<String> screenshots) {
        userExperienceProjectScreenshotRepository.addAll(userExperienceProjectId, screenshots);
        return userExperienceProjectScreenshotRepository.findAllByExperienceProjectId(userExperienceProjectId);
    }

    protected List<String> storeScreenShots(UserExperienceProject userExperienceProject) throws FailedToStoreFileException {
        List<String> screenShotsNames = new ArrayList<>();
        for (UserExperienceProjectScreenshotRequestFile<ScreenShotFile> screenShot : screenShots) {
            String fileName = generateFileName(userExperienceProject.getId());
            screenShotsNames.add(fileName + "." + screenShot.getFileExtension());
            fileStoragePersistAndUrlGetter.store(screenShot.getScreenshot(), fileName, screenShot.getFileExtension(), FilesTypesDirectories.UserProjectScreenshot);
        }
        return screenShotsNames;
    }

    protected String generateFileName(String userExperienceProjectId) {
        return userExperienceProjectId + RandomString.generateRandomString(5);
    }

    protected void checkScreenShotsExtensions() throws FileExtensionNotSupportedException {
        for (UserExperienceProjectScreenshotRequestFile<ScreenShotFile> screenShot : screenShots) {
            if (!CheckSupportedFileExtension.check(screenShot.getFileExtension(), FileExtensions.images())) {
                throw new FileExtensionNotSupportedException();
            }
        }
    }
}
