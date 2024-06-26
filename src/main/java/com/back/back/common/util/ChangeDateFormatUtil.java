package com.back.back.common.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ChangeDateFormatUtil {

    public static String changeYYYYMMDDHHMM(String original) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = simpleDateFormat.parse(original);
        simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }

    public static String changeListDateFormat(String original) throws Exception {

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = inputFormat.parse(original);
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (dateFormat.format(datetime).equals(dateFormat.format(today))) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            return timeFormat.format(datetime);
        } else {
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy.MM.dd");
            return outputFormat.format(datetime);
        }
    }

    public static String getCurrentDatetiem() {
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date now = new Date();
        return simpleDateFormat.format(now);
    }

}
