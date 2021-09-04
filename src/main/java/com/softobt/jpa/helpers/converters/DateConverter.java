package com.softobt.jpa.helpers.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author aobeitor
 * @since 1/21/20
 */
@Component
@Converter
public class DateConverter implements AttributeConverter<LocalDate, Date>{
    @Value("${app.time.zone:GMT+1}")
    private static String timeZone;
    @Value("${app.date.format:dd/MM/yyyy}")
    private static String dateFormat;

    public DateConverter() {
    }

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null : Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date == null ? null : date.toLocalDate();
    }

    public static LocalDate today(){
        return LocalDate.now(ZoneId.of(timeZone));
    }

    public static LocalDate getDateFromString(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(dateFormat));
    }
    public static String getDateInString(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern(dateFormat));
    }
}
