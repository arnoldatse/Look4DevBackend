package dev.arnoldatse.opensource.look4dev.app.dao.userSkill;

import dev.arnoldatse.opensource.look4dev.app.dao.skill.SkillRepository;
import dev.arnoldatse.opensource.look4dev.app.entities.skill.mappers.MapperSkillToCoreSkill;
import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import dev.arnoldatse.opensource.look4dev.app.entities.userSkill.UserSkill;
import dev.arnoldatse.opensource.look4dev.app.entities.skill.Skill;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class CoreUserSkillRepositoryImpl implements dev.arnoldatse.opensource.look4dev.core.users.userExperiencesAndSkills.userSkills.UserSkillRepository {
    private final UserSkillRepository userSkillRepository;
    private final SkillRepository skillRepository;

    @Autowired
    public CoreUserSkillRepositoryImpl(UserSkillRepository userSkillRepository, SkillRepository skillRepository) {
        this.userSkillRepository = userSkillRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    @Transactional
    public List<dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill> getUserSkills(String userId) {
        List<UserSkill> userSkills = userSkillRepository.findByUserId(userId);
        return userSkills.stream()
                .map(UserSkill::getSkill)
                .map(skill -> new MapperSkillToCoreSkill(skill).mapToSkill())
                .toList();
    }

    @Override
    @Transactional
    public List<dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill> addUserSkills(String userId, int[] skillsIds, boolean fromExperience) {
        User user = new User();
        user.setId(userId);

        List<UserSkill> userSkillsToAdd = new ArrayList<>();
        List<dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill> userSkills = this.getUserSkills(userId);
        int[] skillsIdsToAdd = Arrays.stream(skillsIds)
                .filter(skillId -> userSkills.stream().noneMatch(skill -> skill.getId() == skillId))
                .toArray();

        for (int skillId : skillsIdsToAdd) {
            Optional<Skill> optionalSkill = skillRepository.findById(skillId);
            optionalSkill.ifPresent(skill -> userSkillsToAdd.add(new UserSkill(user, skill, fromExperience)));
        }
        userSkillRepository.saveAll(userSkillsToAdd);
        return this.getUserSkills(userId);
    }

    @Override
    @Transactional
    public List<dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill> removeUserSkills(String userId, int[] skillsIds) {
        for (int skillId : skillsIds) {
            userSkillRepository.deleteByUserIdAndSkillId(userId, skillId);
        }
        return this.getUserSkills(userId);
    }
}
