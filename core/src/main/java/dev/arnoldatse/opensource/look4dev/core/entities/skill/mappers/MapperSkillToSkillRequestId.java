package dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;

public class MapperSkillToSkillRequestId implements MapperFromSkill<Integer>{
    private final Skill skill;

    public MapperSkillToSkillRequestId(Skill skill) {
        this.skill = skill;
    }

    @Override
    public Integer mapFromSkill() {
        return skill.getId();
    }
}
