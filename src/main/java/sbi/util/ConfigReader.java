package com.qa.sbi.util;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    private static final String testDataPath = "src/test/resources/testdata.properties";

    public static void loadProperties(String module,String fileName) {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/ObjectRepository/"+module+"/" + fileName + ".properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + fileName + ".properties: " + e.getMessage());
        }
    }

    public static String getLocator(String key) {
//        String value=properties.getProperty(key);
//        System.out.println("🔍 Fetching locator for key: " + key);
//        if (value == null) {
//            System.out.println("   ❌ Key not found: " + key);
//        } else {
//            System.out.println("   ✅ Found locator: " + value);
//        }
        return properties.getProperty(key);
    }

    public static void updateTestDataConfig(String key, String value) throws IOException {
        Properties pr = new Properties();
        Properties pr1 = new Properties();
        FileInputStream fis1 = new FileInputStream("src/test/resources/config/config.properties");
        pr1.load(fis1);
        File file = new File(testDataPath);
        FileInputStream fis = new FileInputStream(file);
        pr.load(fis);
        fis.close();
        pr.setProperty(key, value);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        pr.store(
                fileOutputStream,
                "Updating test data file executed on instance: "+pr1.getProperty("url"));
        fileOutputStream.close();
    }

    public static String getData(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(testDataPath);
        prop.load(fileInputStream);
        return prop.getProperty(key);
    }

}