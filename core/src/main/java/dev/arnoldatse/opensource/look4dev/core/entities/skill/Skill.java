package dev.arnoldatse.opensource.look4dev.core.entities.skill;

import java.util.Date;

public class Skill {
    private int id;
    private String name;
    private Date CreatedAt;

    public Skill(int id, String name, Date createdAt) {
        this.id = id;
        this.name = name;
        CreatedAt = createdAt;
    }

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

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }
}
