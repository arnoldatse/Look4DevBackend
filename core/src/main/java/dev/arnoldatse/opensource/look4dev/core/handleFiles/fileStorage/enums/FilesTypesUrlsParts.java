package dev.arnoldatse.opensource.look4dev.core.handleFiles.fileStorage.enums;

public enum FilesTypesUrlsParts {
    UserProfilePicture("/user-profile-picture/"),
    UserProfileCv("/user-cv/"),
    UserProjectScreenshot("/user-project-screenshot/");

    private final String value;
    FilesTypesUrlsParts(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
