package com.ikwattro.extension.consultor.helper;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

public class JsonHelper
{
    Gson gson = new Gson();

    public Object toObject(String json, Class className)
    {
        json = cleanJson(json);
        Object object = this.gson.fromJson(json, className);

        return object;
    }

    public String toJson(Object object)
    {
        return this.gson.toJson(object);
    }

    private String cleanJson(String json)
    {
        try {
            json = json.trim();
            json = json.startsWith("\"") ? json.substring(1) : json;
            json = json.endsWith("\"") ? json.substring(0, json.length()-1) : json;
            json = json.replace("\\\"", "\"");
        } catch (JsonParseException e) {
            e.printStackTrace();
        }

        return json;
    }
}