package dev.arnoldatse.opensource.look4dev.app.rest;

import dev.arnoldatse.opensource.look4dev.app.users.userSkills.UserSkillsService;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillsRequestIdsDto;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile/skills")
public class UserSkillsController {
    private final UserSkillsService userSkillsService;

    @Autowired
    public UserSkillsController(UserSkillsService userSkillsService) {
        this.userSkillsService = userSkillsService;
    }

    @GetMapping
    public List<SimpleSkillResponseDto> getUserSkills() throws ForbiddenException {
        return userSkillsService.getUserSkills();
    }

    @PostMapping("/add")
    public List<SimpleSkillResponseDto> addUserSkills(@RequestBody SkillsRequestIdsDto skillsRequestIdsDto) throws ForbiddenException {
        return userSkillsService.addUserSkills(skillsRequestIdsDto);
    }

    @PostMapping("/remove")
    public List<SimpleSkillResponseDto> removeUserSkills(@RequestBody SkillsRequestIdsDto skillsRequestIdsDto) throws ForbiddenException {
        return userSkillsService.removeUserSkills(skillsRequestIdsDto);
    }
}
