package dev.arnoldatse.opensource.look4dev.app.dao.skill;

import dev.arnoldatse.opensource.look4dev.app.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.app.entities.skill.mappers.MapperSkillToCoreSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CoreSkillRepository implements dev.arnoldatse.opensource.look4dev.core.skills.SkillRepository {
    private final SkillRepository skillRepository;
    @Autowired
    CoreSkillRepository(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    @Override
    public Optional<dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill> findById(int id) {
        Optional<Skill> optionalSkill = skillRepository.findById(id);
        return optionalSkill.map(skill -> new MapperSkillToCoreSkill(skill).mapToSkill());
    }

    @Override
    public List<dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill> searchByName(String name) {
        return null;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill save(dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill skill) {
        return null;
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill update(dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill skill) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
