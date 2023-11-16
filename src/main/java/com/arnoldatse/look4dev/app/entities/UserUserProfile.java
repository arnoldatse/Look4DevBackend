package com.arnoldatse.look4dev.app.entities;

import com.arnoldatse.look4dev.app.entities.User.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "users_user_profiles")
public class UserUserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="user_profile_id", nullable = false)
    private UserProfile userProfile;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Date createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserUserProfile{" +
                "id=" + id +
                ", user=" + user +
                ", userProfile=" + userProfile.toString() +
                ", createdAt=" + createdAt +
                '}';
    }
}
