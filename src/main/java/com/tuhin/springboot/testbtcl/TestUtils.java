package com.tuhin.springboot.testbtcl;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class TestUtils {
    static String BasePath = "E:\\btcl-automation\\src\\datamigrationGeneric\\test\\";
    static Gson gson = new Gson();

    static <T> List<T> readFromFile(String fileName, Class<T> elementClass) throws FileNotFoundException {
        Type type = getListOfClassType(elementClass);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(new FileReader(BasePath + fileName + ".json")).getAsJsonObject();
        JsonArray data = jsonObject.get("data").getAsJsonArray();
        System.out.println(data);
        return gson.fromJson(data, type);
    }


    static <E> Type getListOfClassType(Class<E> elementClass) {
        return new TypeToken<List<E>>() {
        }
                .where(new TypeParameter<E>() {
                }, elementClass).getType();
    }

}
