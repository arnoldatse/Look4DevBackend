package dev.arnoldatse.opensource.look4dev.app.dao.users;

import dev.arnoldatse.opensource.look4dev.app.entities.User.User;
import org.springframework.data.repository.CrudRepository;

public interface UserJPARepository extends CrudRepository<User, String> {
    User findFirstByEmailOrPseudo(String email, String pseudo);
    User findFirstByEmail(String email);
}
