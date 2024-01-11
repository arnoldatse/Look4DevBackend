package dev.arnoldatse.opensource.look4dev.core.entities.userProfile;

public enum UserProfileName {
    DEVELOPER("DEVELOPER"),
    RECRUITER("RECRUITER");
    private final String value;
    UserProfileName(String userProfileValue){
        value = userProfileValue;
    }

    public String getValue(){
        return value;
    }
}
