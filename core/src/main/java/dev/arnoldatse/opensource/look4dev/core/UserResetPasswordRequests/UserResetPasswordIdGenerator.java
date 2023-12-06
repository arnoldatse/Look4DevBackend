package dev.arnoldatse.opensource.look4dev.core.UserResetPasswordRequests;

import dev.arnoldatse.opensource.look4dev.core.entities.UserResetPasswordRequest.UserResetPasswordRequest;
import dev.arnoldatse.opensource.look4dev.core.utils.RandomString;

public class UserResetPasswordIdGenerator {
    private final UserResetPasswordRequestRepository userResetPasswordRequestRepository;
    public UserResetPasswordIdGenerator(UserResetPasswordRequestRepository userResetPasswordRequestRepository){
        this.userResetPasswordRequestRepository = userResetPasswordRequestRepository;
    }

    public String generateId(){
        int idSize = 60;
        String id = RandomString.generateRandomString(idSize);
        boolean goodIdGenerated = false;

        while (!goodIdGenerated && id.length() == idSize){
            id= RandomString.generateRandomString(idSize);
            if(!checkIdAlreadyExist(id)){
                goodIdGenerated = true;
            }
        }

        return id;
    }

    private boolean checkIdAlreadyExist(String id){
         UserResetPasswordRequest userResetPasswordRequest =  userResetPasswordRequestRepository.findById(id);
         return userResetPasswordRequest != null;
    }
}
