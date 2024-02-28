package dev.arnoldatse.opensource.look4dev.app.entities.userSkill.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.skill.mappers.MapperSkillToCoreSkill;
import dev.arnoldatse.opensource.look4dev.app.entities.user.mappers.MapperUserToCoreUser;
import dev.arnoldatse.opensource.look4dev.app.entities.userSkill.UserSkill;
import dev.arnoldatse.opensource.look4dev.core.entities.userSkill.mappers.MapperToUserSkill;

public class MapperUserSkillToCoreUserSkill implements MapperToUserSkill {
    private final UserSkill userSkill;

    public MapperUserSkillToCoreUserSkill(UserSkill userSkill) {
        this.userSkill = userSkill;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.userSkill.UserSkill mapToUserSkill() {
        return new dev.arnoldatse.opensource.look4dev.core.entities.userSkill.UserSkill(
                userSkill.getId(),
                new MapperUserToCoreUser(userSkill.getUser()).mapToUser(),
                userSkill.isFromExperience(),
                new MapperSkillToCoreSkill(userSkill.getSkill()).mapToSkill()
        );
    }
}
