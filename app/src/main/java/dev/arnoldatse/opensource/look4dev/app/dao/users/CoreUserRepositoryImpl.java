package dev.arnoldatse.opensource.look4dev.app.dao.users;

import dev.arnoldatse.opensource.look4dev.app.entities.user.User;
import dev.arnoldatse.opensource.look4dev.app.entities.user.mappers.MapperCoreUserToUser;
import dev.arnoldatse.opensource.look4dev.app.entities.user.mappers.MapperUserToCoreUser;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.MapperFromUser;
import dev.arnoldatse.opensource.look4dev.core.http.defaultExceptions.RepositoryException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CoreUserRepositoryImpl implements dev.arnoldatse.opensource.look4dev.core.users.UserRepository {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<dev.arnoldatse.opensource.look4dev.core.entities.user.User> findFirstById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return Optional.of(mapUserToCoreUser(user));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<dev.arnoldatse.opensource.look4dev.core.entities.user.User> findFirstByEmailOrPseudo(String emailOrPseudo) {
        User user = userRepository.findFirstByEmailOrPseudo(emailOrPseudo, emailOrPseudo);
        if (user != null) {
            return Optional.of(mapUserToCoreUser(user));
        }
        return Optional.empty();
    }

    @Override
    public Optional<dev.arnoldatse.opensource.look4dev.core.entities.user.User> findFirstByEmail(String email) {
        User user = userRepository.findFirstByEmail(email);
        if (user != null) {
            return Optional.of(mapUserToCoreUser(user));
        }
        return Optional.empty();
    }

    @Override
    public Optional<dev.arnoldatse.opensource.look4dev.core.entities.user.User> findFirstByPseudo(String pseudo) {
        User user = userRepository.findFirstByPseudo(pseudo);
        if (user != null) {
            return Optional.of(mapUserToCoreUser(user));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public dev.arnoldatse.opensource.look4dev.core.entities.user.User saveUser(dev.arnoldatse.opensource.look4dev.core.entities.user.User user) {
        User userCreated = concretSaveUser(user);
        return new MapperUserToCoreUser(userCreated).mapToUser();
    }

    @Override
    @Transactional
    public dev.arnoldatse.opensource.look4dev.core.entities.user.User updateUserDetails(dev.arnoldatse.opensource.look4dev.core.entities.user.User user) throws RepositoryException {
        concretSaveUser(user);
        Optional<User> optionalUserCreated = userRepository.findById(user.getId());
        if (optionalUserCreated.isPresent()) {
            User userCreated = optionalUserCreated.get();
            userCreated.getOtherPlatformUrls();
            userCreated.getSupportedPlatformUrls();
            return new MapperUserToCoreUser(userCreated).mapToUser();
        }
        throw new RepositoryException("Can't find user updated");
    }

    @Override
    @Transactional
    public void updateUserPassword(String userId, String password) {
        userRepository.updatePassword(userId, password);
    }

    @Override
    @Transactional
    public void updateUserPicture(String userId, String picture) {
        userRepository.updatePicture(userId, picture);
    }

    @Override
    @Transactional
    public void updateUserCv(String userId, String cv) {
        userRepository.updateCv(userId, cv);
    }

    private dev.arnoldatse.opensource.look4dev.core.entities.user.User mapUserToCoreUser(User user) {
        return new MapperUserToCoreUser(user).mapToUser();
    }

    private User concretSaveUser(dev.arnoldatse.opensource.look4dev.core.entities.user.User user) {
        MapperFromUser<dev.arnoldatse.opensource.look4dev.app.entities.user.User> coreUserToUserMapper = new MapperCoreUserToUser(user);
        return userRepository.save(coreUserToUserMapper.mapFromUser());
    }

}
