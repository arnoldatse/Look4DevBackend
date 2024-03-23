package dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userSkills;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;

import java.util.List;

public interface UserSkillRepository {
    List<Skill> getUserSkills(String userId);
    List<Skill> addUserSkills(String userId, int[] skillsIds, boolean fromExperience);
    List<Skill> removeUserSkills(String userId, int[] skillsIds);
}
