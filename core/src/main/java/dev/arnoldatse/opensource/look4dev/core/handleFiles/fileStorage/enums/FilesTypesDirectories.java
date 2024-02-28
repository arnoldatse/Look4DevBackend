package dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums;

public enum FilesTypesDirectories {
    UserProfilePicture("userProfilesPictures"),
    UserProfileCv("userProfilesCvs"),
    UserProjectScreenshot("userProjectsScreenshots");

    private final String value;

    FilesTypesDirectories(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
