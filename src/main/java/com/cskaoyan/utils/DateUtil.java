package com.cskaoyan.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class DateUtil {

    public Date getDate(){
        Timestamp timeStamp = new Timestamp(new Date().getTime());
        return timeStamp;
    }
}
