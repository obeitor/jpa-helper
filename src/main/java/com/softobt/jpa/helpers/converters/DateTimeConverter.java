package com.softobt.jpa.helpers.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author aobeitor
 * @since 1/17/20
 */

@Converter
@Component
public class DateTimeConverter implements AttributeConverter<LocalDateTime, Date>{

    @Value("${app.time.zone:GMT+1}")
    private static String timeZone;

    @Value("${app.date.format:yyyy-MM-dd HH:mm:ss}")
    private static String timeFormat;
    public DateTimeConverter(){

    }

    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        } else {
            Instant instant = localDateTime.atZone(ZoneId.of("GMT+1")).toInstant();
            return Date.from(instant);
        }    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        if (date == null) {
            return null;
        } else {
            Instant instant = Instant.ofEpochMilli(date.getTime());
            return LocalDateTime.ofInstant(instant, ZoneId.of("GMT+1"));
        }
    }


    public static LocalDateTime now(){
        return LocalDateTime.now(ZoneId.of(timeZone));
    }

    public static LocalDateTime getDateFromString(String date){
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(timeFormat));
    }
    public static String getDateInString(LocalDateTime date){
        return date.format(DateTimeFormatter.ofPattern(timeFormat));
    }

}
