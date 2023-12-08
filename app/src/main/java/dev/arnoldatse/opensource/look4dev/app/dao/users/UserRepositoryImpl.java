package dev.arnoldatse.opensource.look4dev.app.dao.users;

import dev.arnoldatse.opensource.look4dev.core.entities.user.User;
import dev.arnoldatse.opensource.look4dev.core.entities.user.mappers.UserMapper;
import dev.arnoldatse.opensource.look4dev.core.users.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    UserJPARepository userJPARepository;

    @Override
    public Optional<User> findFirstById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findFirstByEmailOrPseudo(String emailOrPseudo) {
        dev.arnoldatse.opensource.look4dev.app.entities.User userJPA =  userJPARepository.findFirstByEmailOrPseudo(emailOrPseudo, emailOrPseudo);
        if(userJPA!=null){
            return Optional.of(mapUserJPAToUser(userJPA));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findFirstByEmailOrPseudoDistinct(String email, String pseudo) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findFirstByEmail(String email) {
        dev.arnoldatse.opensource.look4dev.app.entities.User userJPA =  userJPARepository.findFirstByEmail(email);
        if(userJPA!=null){
            return Optional.of(mapUserJPAToUser(userJPA));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findFirstByPseudo(String pseudo) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        UserJPAMapper userJPAMapper = new UserJPAMapper(user, new dev.arnoldatse.opensource.look4dev.app.entities.User());
        dev.arnoldatse.opensource.look4dev.app.entities.User userCreated = userJPARepository.save(userJPAMapper.mapToMatchUser());
        userJPAMapper.setMainEntity(new User());
        userJPAMapper.setMatchEntity(userCreated);
        return userJPAMapper.mapToUser();
    }

    private User mapUserJPAToUser(dev.arnoldatse.opensource.look4dev.app.entities.User userJPA){
        User coreUser = new User();
        UserMapper<User, dev.arnoldatse.opensource.look4dev.app.entities.User> mapper = new UserJPAMapper(coreUser, userJPA);
        return mapper.mapToUser();
    }

}
