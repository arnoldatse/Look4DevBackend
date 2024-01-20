package dev.arnoldatse.opensource.look4dev.core.users;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findFirstById(String id);

    Optional<User> findFirstByEmailOrPseudo(String emailOrPseudo);

    Optional<User> findFirstByEmailOrPseudoDistinct(String email, String pseudo);

    Optional<User> findFirstByEmail(String email);

    Optional<User> findFirstByPseudo(String pseudo);

    User saveUser(User user);
    User updateUserDetails(User user);
    void updateUserPassword(String userId, String password);
    void updateUserPicture(String userId, String picture);
}
