package dev.arnoldatse.opensource.look4dev.app.entities.userSkill;

import dev.arnoldatse.opensource.look4dev.app.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "user_skills")
public class UserSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="skill_id", nullable = false)
    private Skill skill;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    public UserSkill() {
    }

    public UserSkill(String id, User user, Skill skill) {
        this.id = id;
        this.user = user;
        this.skill = skill;
    }
    public UserSkill(User user, Skill skill) {
        this.user = user;
        this.skill = skill;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
