package dev.arnoldatse.opensource.look4dev.app.dao.users;

import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findFirstByEmailOrPseudo(String email, String pseudo);
    User findFirstByEmail(String email);
    User findFirstByPseudo(String pseudo);

    @Modifying
    @Query("update User u set u.password = ?2 where u.id = ?1")
    void updatePassword(String userId, String password);

    @Modifying
    @Query("update User u set u.picture = ?2 where u.id = ?1")
    void updatePicture(String userId, String picture);
}
