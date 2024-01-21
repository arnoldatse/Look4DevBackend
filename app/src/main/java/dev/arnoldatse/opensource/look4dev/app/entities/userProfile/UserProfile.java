package dev.arnoldatse.opensource.look4dev.app.entities.userProfile;

import dev.arnoldatse.opensource.look4dev.app.entities.UserUserProfile;
import dev.arnoldatse.opensource.look4dev.core.entities.userProfile.UserProfileName;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private UserProfileName name;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @OneToMany(mappedBy = "userProfile")
    private List<UserUserProfile> userUserProfiles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserProfileName getName() {
        return name;
    }

    public void setName(UserProfileName name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<UserUserProfile> getUserUserProfiles() {
        return userUserProfiles;
    }

    public void addUserUserProfile(UserUserProfile userUserProfile) {
        userUserProfile.setUserProfile(this);
        this.userUserProfiles.add(userUserProfile);
    }

    public void setUserUserProfiles(List<UserUserProfile> userUserProfiles) {
        this.userUserProfiles = userUserProfiles.stream().peek(userUserProfile -> userUserProfile.setUserProfile(this)).toList();
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", userUserProfiles=" + userUserProfiles.toString() +
                '}';
    }
}
