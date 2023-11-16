package com.arnoldatse.look4dev.details.database.springJPA.users;

import com.arnoldatse.look4dev.core.entities.user.User;
import com.arnoldatse.look4dev.core.entities.user.mappers.UserMapper;
import com.arnoldatse.look4dev.core.users.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    UserJPARepository userJPARepository;

    @Override
    public User findFirstById(String id) {
        return null;
    }

    @Override
    public User findFirstByEmailOrPseudo(String emailOrPseudo) {
        com.arnoldatse.look4dev.app.entities.User.User userJPA =  userJPARepository.findFirstByEmailOrPseudo(emailOrPseudo, emailOrPseudo);
        if(userJPA!=null){
            return mapUserJPAToUser(userJPA);
        }
        return null;
    }

    @Override
    public User findFirstByEmailOrPseudoDistinct(String email, String pseudo) {
        return null;
    }

    @Override
    public User findFirstByEmail(String email) {
        com.arnoldatse.look4dev.app.entities.User.User userJPA =  userJPARepository.findFirstByEmail(email);
        if(userJPA!=null){
            return mapUserJPAToUser(userJPA);
        }
        return null;
    }

    @Override
    public User findFirstByPseudo(String pseudo) {
        return null;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        UserJPAMapper userJPAMapper = new UserJPAMapper(user, new com.arnoldatse.look4dev.app.entities.User.User());
        com.arnoldatse.look4dev.app.entities.User.User userCreated = userJPARepository.save(userJPAMapper.mapToMatchUser());
        userJPAMapper.setMainEntity(new User());
        userJPAMapper.setMatchEntity(userCreated);
        return userJPAMapper.mapToUser();
    }

    private User mapUserJPAToUser(com.arnoldatse.look4dev.app.entities.User.User userJPA){
        User coreUser = new User();
        UserMapper<User, com.arnoldatse.look4dev.app.entities.User.User> mapper = new UserJPAMapper(coreUser, userJPA);
        return mapper.mapToUser();
    }

}
