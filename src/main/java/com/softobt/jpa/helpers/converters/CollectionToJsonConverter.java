package com.softobt.jpa.helpers.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Collection;

/**
 * @author aobeitor
 * @since 1/21/20
 */
public class CollectionToJsonConverter implements AttributeConverter<Collection,String> {

    public CollectionToJsonConverter() {
    }

    @Override
    public String convertToDatabaseColumn(Collection collection) {
        return collection == null ? null : new Gson().toJson(collection);
    }

    @Override
    public Collection convertToEntityAttribute(String s) {
        return s==null||s.isEmpty() ? null : (Collection)new Gson().fromJson(s,Collection.class);
    }
}
