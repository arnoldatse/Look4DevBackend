package dev.arnoldatse.opensource.look4dev.app.entities.skill.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperToSkill;

public class MapperSkillToCoreSkill implements MapperToSkill {
    private final Skill skill;

    public MapperSkillToCoreSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill mapToSkill() {
        return new dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill(skill.getId(), skill.getName());
    }
}
