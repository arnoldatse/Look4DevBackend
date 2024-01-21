package dev.arnoldatse.opensource.look4dev.core.users;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.RepositoryException;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findFirstById(String id);

    Optional<User> findFirstByEmailOrPseudo(String emailOrPseudo);

    Optional<User> findFirstByEmail(String email);

    Optional<User> findFirstByPseudo(String pseudo);

    User saveUser(User user);
    User updateUserDetails(User user) throws RepositoryException;
    void updateUserPassword(String userId, String password);
    void updateUserPicture(String userId, String picture);
}
