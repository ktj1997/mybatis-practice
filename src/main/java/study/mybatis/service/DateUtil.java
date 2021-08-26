package study.mybatis.service;

import study.mybatis.exception.NotValidArgumentException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat format = new
            SimpleDateFormat("yyyy-MM-dd");

    public static Date parseStringToDate(String str) {
        try {
            return format.parse(str);
        } catch (Exception e) {
            throw new NotValidArgumentException();
        }
    }
}
