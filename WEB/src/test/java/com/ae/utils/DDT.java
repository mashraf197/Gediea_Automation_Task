package com.ae.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DDT {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() throws IOException {
        return readCsvData("src/test/resources/testdata/loginData.csv");
    }

    private static Object[][] readCsvData(String filePath) throws IOException {
        List<Object[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) { // skip header
                    isFirstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                data.add(new Object[]{parts[0], parts[1], parts[2]});
            }
        }
        return data.toArray(new Object[0][0]);
    }
}
