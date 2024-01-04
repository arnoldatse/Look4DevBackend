package dev.arnoldatse.opensource.look4dev.app.dao.userResetPasswordRequest;

import dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest.mappers.MapperCoreUserResetPasswordRequestToUserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest.mappers.MapperUserResetPasswordRequestToCoreUserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.mappers.MapperFromUserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.mappers.MapperToUserResetPasswordRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CoreUserResetPasswordRequestRepositoryImpl implements dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests.UserResetPasswordRequestRepository {
    @Autowired
    UserResetPasswordRequestRepository userResetPasswordRequestRepository;

    @Override
    @Transactional
    public void save(dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest userResetPasswordRequest) {
        MapperFromUserResetPasswordRequest<dev.arnoldatse.opensource.look4dev.app.entities.userResetPasswordRequest.UserResetPasswordRequest> mapperCoreUserResetPasswordRequestToUserResetPasswordRequest = new MapperCoreUserResetPasswordRequestToUserResetPasswordRequest(userResetPasswordRequest);
        userResetPasswordRequestRepository.save(mapperCoreUserResetPasswordRequestToUserResetPasswordRequest.mapFromUserResetPasswordRequest());
    }

    @Override
    public Optional<dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest> findById(String id) {
        Optional<UserResetPasswordRequest> optionalUserResetPasswordRequest = userResetPasswordRequestRepository.findById(id);
        if (optionalUserResetPasswordRequest.isPresent()) {
            MapperToUserResetPasswordRequest mapperUserResetPasswordRequestToCoreUserResetPasswordRequest = new MapperUserResetPasswordRequestToCoreUserResetPasswordRequest(optionalUserResetPasswordRequest.get());
            return Optional.of(mapperUserResetPasswordRequestToCoreUserResetPasswordRequest.mapToUserResetPasswordRequest());
        }
        return Optional.empty();
    }

    @Override
    public dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest findFirstByUserId(String userId) {
        return null;
    }

    @Override
    public List<dev.arnoldatse.opensource.look4dev.core.entities.userResetPasswordRequest.UserResetPasswordRequest> findAllByUserId(String userId) {
        return null;
    }

    @Override
    public void deleteAllByUserId(String userId) {

    }
}
