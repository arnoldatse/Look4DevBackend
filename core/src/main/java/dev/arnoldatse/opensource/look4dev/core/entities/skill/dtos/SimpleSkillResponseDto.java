package dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos;

/**
 * This class is used to return a skill without createdAt property as HTTP response
 */
public class SimpleSkillResponseDto {
    private int id;
    private String name;

    public SimpleSkillResponseDto(int id, String name) {
        this.id = id;
        this.name = name;
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
}
