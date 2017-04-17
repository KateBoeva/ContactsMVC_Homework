package ru.itis.hw.contacts.dao.utils;

import java.util.List;
import java.util.Map;

public interface ParamsMapper {

    /**
     * Create Map from Lists
     * @param keys
     * @param values
     * @return Map<String, Object>
     */
    Map<String, Object> asMap(List<String> keys, List<?> values);

}
