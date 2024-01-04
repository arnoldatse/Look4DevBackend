package dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest;

import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "user_reset_password_requests")
public class UserResetPasswordRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserResetPasswordRequest{" +
                "id='" + id + '\'' +
                ", expirationDate=" + expirationDate +
                ", createdAt=" + createdAt +
                ", user=" + user +
                '}';
    }
}
