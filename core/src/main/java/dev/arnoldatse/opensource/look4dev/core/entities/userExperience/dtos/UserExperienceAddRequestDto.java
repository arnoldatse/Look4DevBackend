package dev.arnoldatse.opensource.look4dev.core.entities.userExperience.dtos;

import dev.arnoldatse.opensource.look4dev.core.entities.skill.dtos.SkillsRequestIdsDto;
import dev.arnoldatse.opensource.look4dev.core.entities.userExperienceProject.dtos.UserExperienceProjectRequestDto;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class UserExperienceAddRequestDto {
    private String company;
    private String title;
    private String description;
    private Data startDate;
    private Date endDate;
    private boolean current;
    private List<UserExperienceProjectRequestDto> projects;
    private SkillsRequestIdsDto skills;

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

    public List<UserExperienceProjectRequestDto> getProjects() {
        return projects;
    }

    public void setProjects(List<UserExperienceProjectRequestDto> projects) {
        this.projects = projects;
    }

    public SkillsRequestIdsDto getSkills() {
        return skills;
    }

    public void setSkills(SkillsRequestIdsDto skills) {
        this.skills = skills;
    }
}
