package com.arnoldatse.look4dev.core.http;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatResponseDate {
    public static String format(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
