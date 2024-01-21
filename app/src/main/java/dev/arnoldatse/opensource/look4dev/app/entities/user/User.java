package dev.arnoldatse.opensource.look4dev.app.entities.user;

import dev.arnoldatse.opensource.look4dev.app.entities.UserUserProfile;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlOtherPlatform.UserUrlOtherPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String firstname;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String pseudo;

    private String picture;
    private String bio;
    private String cv;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserUserProfile> userUserProfiles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserUrlOtherPlatform> otherPlatformUrls;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserUrlSupportedPlatform> supportedPlatformUrls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<UserUserProfile> getUserUserProfiles() {
        return userUserProfiles;
    }

    public void addUserUserProfile(UserUserProfile userUserProfile) {
        userUserProfile.setUser(this);
        this.userUserProfiles.add(userUserProfile);
    }

    public void setUserUserProfiles(List<UserUserProfile> userUserProfiles) {
        this.userUserProfiles = userUserProfiles.stream().peek(userUserProfile -> userUserProfile.setUser(this)).toList();
    }

    public List<UserUrlOtherPlatform> getOtherPlatformUrls() {
        return otherPlatformUrls;
    }

    public void addOtherPlatformUrl(UserUrlOtherPlatform otherPlatformUrl){
        otherPlatformUrl.setUser(this);
        this.otherPlatformUrls.add(otherPlatformUrl);
    }

    public void setOtherPlatformUrls(List<UserUrlOtherPlatform> otherPlatformUrls) {
        this.otherPlatformUrls = otherPlatformUrls.stream().peek(otherPlatformUrl->otherPlatformUrl.setUser(this)).toList();
    }

    public List<UserUrlSupportedPlatform> getSupportedPlatformUrls() {
        return supportedPlatformUrls;
    }

    public void addSupportedPlatformUrls(UserUrlSupportedPlatform supportedPlatformUrl){
        supportedPlatformUrl.setUser(this);
        this.supportedPlatformUrls.add(supportedPlatformUrl);
    }

    public void setSupportedPlatformUrls(List<UserUrlSupportedPlatform> supportedPlatformUrls) {
        this.supportedPlatformUrls = supportedPlatformUrls.stream().peek(supportedPlatformUrl->supportedPlatformUrl.setUser(this)).toList();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", picture='" + picture + '\'' +
                ", bio='" + bio + '\'' +
                ", cv='" + cv + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
