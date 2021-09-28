package com.bssystem.commons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/**
 * json对象相互转化工具类
 */
@Component
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static Gson gson = null;

    static {
        gson = new Gson();
    }

    public static String convertObj2String(Object object) {
        String s = null;
        try {
            s = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static <T> T convertString2Obj(String s, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(s, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }


    public static synchronized Gson newInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T toBean(String json, Class<T> clz) {

        return gson.fromJson(json, clz);
    }

    public static <T> Map<String, T> toMap(String json, Class<T> clz) {
        Map<String, JsonObject> map = gson.fromJson(json, new TypeToken<Map<String, JsonObject>>() {
        }.getType());
        Map<String, T> result = new HashMap<>();
        for (String key : map.keySet()) {
            result.put(key, gson.fromJson(map.get(key), clz));
        }
        return result;
    }

    public static Map<String, Object> toMap(String json) {
        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
        }.getType());
        return map;
    }

    public static <T> List<T> toList(String json, Class<T> clz) {
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        List<T> list = new ArrayList<>();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, clz));
        }
        return list;
    }

    /**
     * 把List<String>转换为List<T>
     *
     * @param oldlist
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> List<T> list2List(List<String> oldlist, Class<T> clz) {
        List<T> list = new ArrayList<>();
        for (String elem : oldlist) {
            list.add(toBean(elem, clz));
        }
        return list;
    }

    public static List<Map<String, Object>> setToListInMap(Set<String> set) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (String s : set) {
            Map<String, Object> map = JsonUtil.toMap(s);
            list.add(map);
        }
        return list;
    }

}