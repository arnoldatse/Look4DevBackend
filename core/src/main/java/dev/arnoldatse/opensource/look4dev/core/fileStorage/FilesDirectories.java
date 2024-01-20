package dev.arnoldatse.opensource.look4dev.core.fileStorage;

public enum FilesDirectories {
    UserProfilePicture("/userProfilePictures");

    private final String value;

    FilesDirectories(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
