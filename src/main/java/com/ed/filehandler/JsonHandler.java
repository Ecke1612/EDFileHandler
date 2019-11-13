package com.ed.filehandler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonHandler {

    public void writeJsonData(JSONObject jobj, String path) {
        try (FileWriter file = new FileWriter(path)) {

            file.write(jobj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJsonArrayData(JSONArray array, String path) {
        try (FileWriter file = new FileWriter(path)) {

            file.write(array.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject readJsonData(String path) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path))
        {
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            return obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray readJsonArrayData(String path) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path))
        {
            JSONArray array = (JSONArray) jsonParser.parse(reader);
            return array;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
