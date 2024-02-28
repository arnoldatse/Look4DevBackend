package dev.arnoldatse.opensource.look4dev.app.entities.userSkill.mappers;

import dev.arnoldatse.opensource.look4dev.app.entities.skill.mappers.MapperCoreSkillToSkill;
import dev.arnoldatse.opensource.look4dev.app.entities.user.mappers.MapperCoreUserToUser;
import dev.arnoldatse.opensource.look4dev.app.entities.userSkill.UserSkill;
import dev.arnoldatse.opensource.look4dev.core.entities.userSkill.mappers.MapperFromUserSkill;

public class MapperCoreUserSkillToUserSkill implements MapperFromUserSkill<UserSkill> {
    private final dev.arnoldatse.opensource.look4dev.core.entities.userSkill.UserSkill coreUserSkill;

    public MapperCoreUserSkillToUserSkill(dev.arnoldatse.opensource.look4dev.core.entities.userSkill.UserSkill coreUserSkill) {
        this.coreUserSkill = coreUserSkill;
    }

    @Override
    public UserSkill mapFromUserSkill() {
        return new UserSkill(
                coreUserSkill.getId(),
                new MapperCoreUserToUser(coreUserSkill.getUser()).mapFromUser(),
                new MapperCoreSkillToSkill(coreUserSkill.getSkill()).mapFromSkill(),
                coreUserSkill.isFromExperience()
        );
    }
}
