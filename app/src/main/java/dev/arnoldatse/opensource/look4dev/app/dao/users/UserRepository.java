package dev.arnoldatse.opensource.look4dev.app.dao.users;

import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findFirstByEmailOrPseudo(String email, String pseudo);
    User findFirstByEmail(String email);
}
