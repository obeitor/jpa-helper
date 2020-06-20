package com.softobt.jpa.helpers.converters;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;

/**
 * @author aobeitor
 * @since 1/21/20
 */
@Component
@Converter
public class DateConverter implements AttributeConverter<LocalDate, Date>{

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
}
