package dev.arnoldatse.opensource.look4dev.core.fileStorage.enums;

public enum FilesDirectories {
    UserProfilePicture("userProfilesPictures"),
    UserProfileCv("userProfilesCvs");

    private final String value;

    FilesDirectories(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
