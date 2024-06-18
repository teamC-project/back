package com.back.back.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeDateFormatUtil {
    
    public static String changeYYMMDD(String original) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = simpleDateFormat.parse(original);
        simpleDateFormat = new SimpleDateFormat("yy.MM.dd");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }
    public static String changeYYMMDDHHMMDD(String original) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = simpleDateFormat.parse(original);
        simpleDateFormat = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }

    public static String changeYYYYMMDDHHMM(String original) throws Exception {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date datetime = simpleDateFormat.parse(original);
    simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    String writeDatetime = simpleDateFormat.format(datetime);
    return writeDatetime;
  }

    public static String changeYYYYMMDD(String original) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = simpleDateFormat.parse(original);
        simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }

    public static String changeYYMM(String original) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = simpleDateFormat.parse(original);
        simpleDateFormat = new SimpleDateFormat("yy.MM");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }

    // 수정: changeYYYYMMDDHHMM 메서드 대신 custom 메서드 사용
    public static String changeCustomerListDateFormat(String original) throws Exception {
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
}
