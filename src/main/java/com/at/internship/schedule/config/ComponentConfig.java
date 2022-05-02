package com.at.internship.schedule.config;

import com.at.internship.schedule.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentConfig {

    private static final String PROP_FORMAT_DATETIME_DEFAULT="${com.at.internship.format.datetime.default}";
    private static final String PROP_FORMAT_DATE_DEFAULT="${com.at.internship.format.date.default}";

    @Value(PROP_FORMAT_DATETIME_DEFAULT)
    private String defaultDateTimeFormat;
    @Value(PROP_FORMAT_DATE_DEFAULT)
    private String defaultDateFormat;

    @Bean
    public DateUtils dateUtils(){
        return new DateUtils(defaultDateTimeFormat, defaultDateFormat);
    }
}
