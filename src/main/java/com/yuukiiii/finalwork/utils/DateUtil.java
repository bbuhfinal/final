package com.yuukiiii.finalwork.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yuukiiii
 * on 2018/4/13 14:50
 */


public class DateUtil {

    private Date date;

    private SimpleDateFormat simpleDateFormat;

    private String dateString;

    public DateUtil() {
        this.date = new Date();
        this.simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dateString = simpleDateFormat.format(date);
    }

    public String getDateString() {
        return dateString;
    }
}
