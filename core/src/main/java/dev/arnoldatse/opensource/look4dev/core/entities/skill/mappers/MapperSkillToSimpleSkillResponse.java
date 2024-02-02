package dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;

public class MapperSkillToSimpleSkillResponse implements MapperFromSkill<SimpleSkillResponseDto>{
    private final Skill skill;

    public MapperSkillToSimpleSkillResponse(Skill skill) {
        this.skill = skill;
    }

    @Override
    public SimpleSkillResponseDto mapFromSkill() {
        return new SimpleSkillResponseDto(skill.getId(), skill.getName());
    }
}
