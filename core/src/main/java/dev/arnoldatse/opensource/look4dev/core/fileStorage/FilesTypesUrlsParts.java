package dev.arnoldatse.opensource.look4dev.core.fileStorage;

public enum FilesTypesUrlsParts {
    UserProfilePicture("/user-profiles/"),
    UserProfileCv("/user-cv/");

    private final String value;
    FilesTypesUrlsParts(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
