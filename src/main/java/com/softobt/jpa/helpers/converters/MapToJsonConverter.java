package com.softobt.jpa.helpers.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import lombok.val;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

public class MapToJsonConverter implements AttributeConverter<Map<String,Object>,String> {
    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        return stringObjectMap == null ? null : new Gson().toJson(stringObjectMap);
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            return new Gson().fromJson(s, Map.class);
        }catch (Exception e){
            return new HashMap<>();
        }
    }
}
