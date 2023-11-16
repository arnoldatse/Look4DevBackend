package com.arnoldatse.look4dev.details.database.springJPA.users;

import com.arnoldatse.look4dev.app.entities.User.User;
import org.springframework.data.repository.CrudRepository;

public interface UserJPARepository extends CrudRepository<User, String> {
    User findFirstByEmailOrPseudo(String email, String pseudo);
    User findFirstByEmail(String email);
}
