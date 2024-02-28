package dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProjectScreenshot;

public class UserExperienceProjectScreenshotRequestFile<ScreenshotFile> {
    private ScreenshotFile screenshot;
    private String fileExtension;

    public UserExperienceProjectScreenshotRequestFile(ScreenshotFile screenshot, String fileExtension) {
        this.screenshot = screenshot;
        this.fileExtension = fileExtension;
    }

    public ScreenshotFile getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(ScreenshotFile screenshot) {
        this.screenshot = screenshot;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}
