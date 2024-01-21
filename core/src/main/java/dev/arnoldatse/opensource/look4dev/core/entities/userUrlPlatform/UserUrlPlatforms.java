package dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform;

import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.core.entities.userUrlPlatform.userUrlSupportedPlatform.UserUrlSupportedPlatform;

import java.util.ArrayList;
import java.util.List;

public class UserUrlPlatforms {
    private List<UserUrlOtherPlatform> urlOtherPlatforms = new ArrayList<>();
    private List<UserUrlSupportedPlatform> urlSupportedPlatforms = new ArrayList<>();

    public UserUrlPlatforms() {
    }

    public UserUrlPlatforms(List<UserUrlOtherPlatform> urlOtherPlatforms, List<UserUrlSupportedPlatform> urlSupportedPlatforms) {
        this.urlOtherPlatforms = urlOtherPlatforms;
        this.urlSupportedPlatforms = urlSupportedPlatforms;
    }

    public UserUrlPlatforms(UserUrlPlatforms userUrlPlatforms) {
        this.urlOtherPlatforms = userUrlPlatforms.getUrlOtherPlatforms()
                .stream()
                .map(UserUrlOtherPlatform::clone).toList();
        this.urlSupportedPlatforms = userUrlPlatforms.getUrlSupportedPlatforms()
                .stream()
                .map(UserUrlSupportedPlatform::clone)
                .toList();
    }

    public List<UserUrlOtherPlatform> getUrlOtherPlatforms() {
        return urlOtherPlatforms;
    }

    public void setUrlOtherPlatforms(List<UserUrlOtherPlatform> otherUrlPlatforms) {
        this.urlOtherPlatforms = otherUrlPlatforms;
    }

    public void addUrlOtherPlatform(UserUrlOtherPlatform otherPlatform){
        this.urlOtherPlatforms.add(otherPlatform);
    }

    public List<UserUrlSupportedPlatform> getUrlSupportedPlatforms() {
        return urlSupportedPlatforms;
    }

    public void setUrlSupportedPlatforms(List<UserUrlSupportedPlatform> urlSupportedPlatforms) {
        this.urlSupportedPlatforms = urlSupportedPlatforms;
    }

    public void addUrlSupportedPlatform(UserUrlSupportedPlatform urlSupportedPlatform){
        this.urlSupportedPlatforms.add(urlSupportedPlatform);
    }

    public UserUrlPlatforms clone(){
        return new UserUrlPlatforms(this);
    }
}
