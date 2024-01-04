package dev.arnoldatse.opensource.look4dev.app.entities.urlSupportedPlatform;

import dev.arnoldatse.opensource.look4dev.app.entities.userUrlPlatforms.userUrlSupportedPlatform.UserUrlSupportedPlatform;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "url_supported_platforms")
public class UrlSupportedPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)

    private String label;

    @Column(name = "logo", nullable = false)
    private String logoPath;

    @CreationTimestamp
    private Date CreatedAt;

    @UpdateTimestamp
    private Date UpdatedAt;

    @OneToMany(mappedBy = "supportedPlatform")
    private List<UserUrlSupportedPlatform> UserSupportedPlatformUrls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }

    public List<UserUrlSupportedPlatform> getUserSupportedPlatformUrls() {
        return UserSupportedPlatformUrls;
    }
}
