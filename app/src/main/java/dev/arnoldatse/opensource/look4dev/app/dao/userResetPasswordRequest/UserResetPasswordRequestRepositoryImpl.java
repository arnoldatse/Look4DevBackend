package dev.arnoldatse.opensource.look4dev.app.dao.userResetPasswordRequest;

import dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.mappers.UserResetPasswordRequestMapper;
import dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.UserResetPasswordRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserResetPasswordRequestRepositoryImpl implements UserResetPasswordRequestRepository {
    @Autowired
    UserResetPasswordRequestJPARepository userResetPasswordRequestJPARepository;

    @Override
    public void save(UserResetPasswordRequest userResetPasswordRequest) {
        UserResetPasswordRequestJPAMapper userResetPasswordRequestJPAMapper = new UserResetPasswordRequestJPAMapper(userResetPasswordRequest, new dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest());
        dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest userResetPasswordRequestJPACreated = userResetPasswordRequestJPARepository.save(userResetPasswordRequestJPAMapper.mapToMatchUserResetPasswordRequest());
        userResetPasswordRequestJPAMapper.setMatchEntity(userResetPasswordRequestJPACreated);
    }

    @Override
    public Optional<UserResetPasswordRequest> findById(String id) {
        Optional<dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest> optionalUserResetPasswordRequest = userResetPasswordRequestJPARepository.findById(id);
        if (optionalUserResetPasswordRequest.isPresent()) {
            UserResetPasswordRequestMapper<UserResetPasswordRequest, dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest> userResetPasswordRequestMapper = new UserResetPasswordRequestJPAMapper(new UserResetPasswordRequest(), optionalUserResetPasswordRequest.get());
            return Optional.of(userResetPasswordRequestMapper.mapToUserResetPasswordRequest());
        }
        return Optional.empty();
    }

    @Override
    public UserResetPasswordRequest findFirstByUserId(String userId) {
        return null;
    }

    @Override
    public List<UserResetPasswordRequest> findAllByUserId(String userId) {
        return null;
    }

    @Override
    public void deleteAllByUserId(String userId) {

    }
}
