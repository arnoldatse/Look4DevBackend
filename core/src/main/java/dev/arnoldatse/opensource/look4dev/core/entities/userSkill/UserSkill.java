package dev.arnoldatse.opensource.look4dev.core.entities.userSkill;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.user.User;

import java.util.Date;

public class UserSkill {
    private String id;
    private User user;
    private Skill skill;
    private Date createdAt;

    public UserSkill(String id, User user, Skill skill, Date createdAt) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.createdAt = createdAt;
    }
    public UserSkill(String id, User user, Skill skill) {
        this.id = id;
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
