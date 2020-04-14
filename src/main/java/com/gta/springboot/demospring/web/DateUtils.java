package com.gta.springboot.demospring.web;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

    private static final DateFormat DATE_FORMAT= new SimpleDateFormat("yyyy-MM-dd");

    public static Date createDateFromDateString(String dateString) {
        Date date = null;
        if (null != dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException e) {
                date = new Date();
            }
        } else {
            date = new Date();
        }
        return date;
    }
}
