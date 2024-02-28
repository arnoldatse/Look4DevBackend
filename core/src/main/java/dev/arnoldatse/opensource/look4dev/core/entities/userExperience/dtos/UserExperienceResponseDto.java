package dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SimpleSkillResponseDto;
import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillsRequestIdsDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.UserExperienceProject;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.dtos.UserExperienceProjectRequestDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.dtos.UserExperienceProjectResponseDto;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class UserExperienceResponseDto {
    private String company;
    private String title;
    private String description;
    private Data startDate;
    private Date endDate;
    private boolean current;
    private List<UserExperienceProjectResponseDto> projects;
    private List<SimpleSkillResponseDto> skills;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Data getStartDate() {
        return startDate;
    }

    public void setStartDate(Data startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public List<UserExperienceProjectResponseDto> getProjects() {
        return projects;
    }

    public void setProjects(List<UserExperienceProjectResponseDto> projects) {
        this.projects = projects;
    }

    public List<SimpleSkillResponseDto> getSkills() {
        return skills;
    }

    public void setSkills(List<SimpleSkillResponseDto> skills) {
        this.skills = skills;
    }
}
