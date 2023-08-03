package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String testsFile = "tests.json";
        String valuesFile = "values.json";
        String reportFile = "report.json";

        String testsJson = readJsonFile(testsFile);
        String valuesJson = readJsonFile(valuesFile);

        JSONObject testsObj = new JSONObject(testsJson);
        JSONObject valuesObj = new JSONObject(valuesJson);

        updateTestValues(testsObj.getJSONArray("tests"), valuesObj.getJSONArray("values"));

        String reportJson = testsObj.toString(2);
        saveReportToFile(reportJson, reportFile);
    }

    static String readJsonFile(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    static void updateTestValues(JSONArray testsArray, JSONArray valuesArray) {
        for (int i = 0; i < testsArray.length(); i++) {
            JSONObject test = testsArray.getJSONObject(i);
            int testId = test.getInt("id");
            for (int j = 0; j < valuesArray.length(); j++) {
                JSONObject value = valuesArray.getJSONObject(j);
                if (value.getInt("id") == testId) {
                    test.put("value", value.getString("value"));
                    break;
                }
            }
            if (test.has("values")) {
                updateTestValues(test.getJSONArray("values"), valuesArray);
            }
        }
    }

    static void saveReportToFile(String reportJson, String filePath) {
        try {
            Files.write(Paths.get(filePath), reportJson.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
