package dev.arnoldatse.opensource.look4dev.core.userResetPasswordRequests;

import dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.utils.RandomString;

import java.util.Optional;

public class UserResetPasswordIdGenerator {
    private final UserResetPasswordRequestRepository userResetPasswordRequestRepository;
    public UserResetPasswordIdGenerator(UserResetPasswordRequestRepository userResetPasswordRequestRepository){
        this.userResetPasswordRequestRepository = userResetPasswordRequestRepository;
    }

    public String generateId(){
        int idSize = 60;
        String id;
        boolean goodIdGenerated = false;

        do{
            id= RandomString.generateRandomString(idSize);
            if(checkIdNotExist(id)){
                goodIdGenerated = true;
            }
        }while(!goodIdGenerated && id.length() == idSize);

        return id;
    }

    private boolean checkIdNotExist(String id){
         Optional<UserResetPasswordRequest> OptionalUserResetPasswordRequest =  userResetPasswordRequestRepository.findById(id);
         return OptionalUserResetPasswordRequest.isEmpty();
    }
}
