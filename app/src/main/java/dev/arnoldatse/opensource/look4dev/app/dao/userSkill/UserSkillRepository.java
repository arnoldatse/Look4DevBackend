package dev.arnoldatse.opensource.look4dev.app.dao.userSkill;

import dev.arnoldatse.opensource.look4dev.app.entities.userSkill.UserSkill;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserSkillRepository extends CrudRepository<UserSkill, String> {
    @Query("select us from UserSkill us where us.user.id = ?1")
    List<UserSkill> findByUserId(String userId);

    @Modifying
    @Query("delete from UserSkill us where us.user.id = ?1 and us.skill.id = ?2")
    void deleteByUserIdAndSkillId(String userId, int skillId);
}
