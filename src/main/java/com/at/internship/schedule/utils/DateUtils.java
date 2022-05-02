package com.at.internship.schedule.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

//    private final String defaultDateTimeFormat = "MM/dd/yyyy hh:mm:ss";
//    private final String defaultDateFormat = "MM/dd/yyyy";
    private final String defaultDateTimeFormat;
    private final String defaultDateFormat;

    public DateUtils(String defaultDateTimeFormat, String defaultDateFormat) {
        this.defaultDateTimeFormat = defaultDateTimeFormat;
        this.defaultDateFormat = defaultDateFormat;
    }

    public String formatDefault(LocalDateTime dateTime) {
        if(dateTime == null) return null;
        return dateTime.format(DateTimeFormatter.ofPattern(defaultDateTimeFormat));
    }

    public String formatDefault(LocalDate date) {
        if(date == null) return null;
        return date.format(DateTimeFormatter.ofPattern(defaultDateFormat));
    }

}
