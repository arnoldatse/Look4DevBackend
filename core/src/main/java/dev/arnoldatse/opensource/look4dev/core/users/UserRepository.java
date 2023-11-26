package dev.arnoldatse.opensource.look4dev.core.users;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;

public interface UserRepository {
    public User findFirstById(String id);

    public User findFirstByEmailOrPseudo(String emailOrPseudo);

    public User findFirstByEmailOrPseudoDistinct(String email, String pseudo);

    public User findFirstByEmail(String email);

    public User findFirstByPseudo(String pseudo);

    public User saveUser(User user);
}
