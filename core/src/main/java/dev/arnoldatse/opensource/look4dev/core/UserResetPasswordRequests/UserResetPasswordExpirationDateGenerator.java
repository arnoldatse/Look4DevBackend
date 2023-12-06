package dev.arnoldatse.opensource.look4dev.core.UserResetPasswordRequests;

import java.util.Calendar;
import java.util.Date;

public class UserResetPasswordExpirationDateGenerator {

    public Date generateExpirationDate(){
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.HOUR_OF_DAY, 24);

        return calendar.getTime();
    }
}
