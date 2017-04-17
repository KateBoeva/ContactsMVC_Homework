package ru.itis.hw.contacts.dao.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ParamsMapperImpl implements ParamsMapper {
    public Map<String, Object> asMap(List<String> keys, List<?> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        } else {
            Map<String, Object> result = new HashMap<String, Object>();
            for (int i = 0; i < keys.size(); i++) {
                result.put(keys.get(i), values.get(i));
            }
            return result;
        }
    }
}
