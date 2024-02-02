package dev.arnoldatse.opensource.look4dev.core.userSkill;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillsRequestIdsDto;

import java.util.List;

public interface UserSkillRepository {
    List<Skill> getUserSkills(String userId);
    List<Skill> addUserSkills(String userId, SkillsRequestIdsDto skillsIds);
    List<Skill> removeUserSkills(String userId, SkillsRequestIdsDto skillsIds);
}
