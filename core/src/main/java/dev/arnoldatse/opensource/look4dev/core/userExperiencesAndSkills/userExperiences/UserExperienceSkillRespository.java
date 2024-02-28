package dev.arnoldatse.opensource.look4dev.core.userExperiencesAndSkills.userExperiences;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;

public interface UserExperienceSkillRespository {
    Skill save(String userExperienceId, int skillId);
    void delete(String userExperienceId, int skillId);
    void deleteAll(String userExperienceId);
}
