package dev.arnoldatse.opensource.look4dev.app.entities.skill.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperFromSkill;

public class MapperCoreSkillToSkill implements MapperFromSkill<Skill> {
    private final dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill coreSkill;

    public MapperCoreSkillToSkill(dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill coreSkill) {
        this.coreSkill = coreSkill;
    }

    @Override
    public Skill mapFromSkill() {
        return new Skill(coreSkill.getId(), coreSkill.getName());
    }
}
