package com.softobt.jpa.helpers.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author aobeitor
 * @since 1/17/20
 */

@Converter
@Component
public class DateTimeConverter implements AttributeConverter<LocalDateTime, Date>{

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


}
