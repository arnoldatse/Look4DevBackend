package dev.arnoldatse.opensource.look4dev.core.http;

public enum TypeFilePartUrls {
    UserProfilePicture("/profile-picture/");

    private final String value;

    TypeFilePartUrls(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
