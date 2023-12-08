package dev.arnoldatse.opensource.look4dev.app.dao.userResetPasswordRequest;

import dev.arnoldatse.opensource.look4dev.app.entities.UserResetPasswordRequest;
import org.springframework.data.repository.CrudRepository;

public interface UserResetPasswordRequestJPARepository extends CrudRepository<UserResetPasswordRequest, String> {

}
