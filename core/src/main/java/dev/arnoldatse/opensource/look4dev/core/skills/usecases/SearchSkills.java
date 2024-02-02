package dev.arnoldatse.opensource.look4dev.core.skills.usecases;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.Skill;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillSearchRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.mappers.MapperSkillToSimpleSkillResponse;
import dev.arnoldatse.opensource.look4dev.core.skills.SkillRepository;

import java.util.List;

public class SearchSkills {
    private final SkillRepository skillRepository;
    private final SkillSearchRequestDto skillSearchRequest;

    public SearchSkills(SkillRepository skillRepository, SkillSearchRequestDto skillSearchRequest) {
        this.skillRepository = skillRepository;
        this.skillSearchRequest = skillSearchRequest;
    }

    public List<SimpleSkillResponseDto> execute() {
        List<Skill> skills = skillRepository.searchByName(skillSearchRequest.skillName());
        return skills.stream().map(skill -> new MapperSkillToSimpleSkillResponse(skill).mapFromSkill()).toList();
    }
}
