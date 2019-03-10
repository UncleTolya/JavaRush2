package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <T extends Convertable, K extends Object> Map<K, T> convert(List<T> list) {
        Map<K, T> result = new HashMap<>();
        for (T value : list) {
            result.put((K) value.getKey(), value);
        }
        return result;
    }
}
