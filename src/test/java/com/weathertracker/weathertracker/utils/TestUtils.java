package com.weathertracker.weathertracker.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class TestUtils {
    public static JSONObject createJsonFromFile(String filePath) throws IOException, ParseException {
        FileReader fileReader = new FileReader(filePath);
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(fileReader);
    }
}
