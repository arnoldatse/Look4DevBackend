package dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform;

import dev.arnoldatse.opensource.look4dev.app.entities.urlSupportedPlatform.UrlSupportedPlatform;
import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "user_url_supported_platforms")
public class UserUrlSupportedPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String url;

    @Column(name ="created_at" ,nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "url_supported_platform_id")
    private UrlSupportedPlatform supportedPlatform;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UrlSupportedPlatform getSupportedPlatform() {
        return supportedPlatform;
    }

    public void setSupportedPlatform(UrlSupportedPlatform supportedPlatform) {
        this.supportedPlatform = supportedPlatform;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
