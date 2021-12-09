package com.example.criccard.entities;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Convertor {
    // type converter for ball list type
    @TypeConverter
    public static List<Ball> ballsFromString(String value) {
        if (value == null) return Collections.emptyList();
        Type listType = new TypeToken<ArrayList<Ball>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String ballStringFromArrayList(List<Ball> list) {
        if (list == null) return null;
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // type converter for team classes
    @TypeConverter
    public static List<Team> teamsFromString(String value) {
        if (value == null) return Collections.emptyList();
        Type listType = new TypeToken<ArrayList<Team>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String teamStringFromArrayList(List<Team> list) {
        if (list == null) return null;
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
