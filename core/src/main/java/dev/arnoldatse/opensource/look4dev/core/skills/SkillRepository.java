package dev.arnoldatse.opensource.look4dev.core.skills;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillRepository {
    Optional<Skill> findById(int id);
    List<Skill> searchByName(String name);
    Skill save(Skill skill);
    Skill update(Skill skill);
    void delete(int id);
}
