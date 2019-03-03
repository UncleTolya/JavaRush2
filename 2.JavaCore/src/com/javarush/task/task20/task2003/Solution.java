package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prop = new Properties();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis =  new FileInputStream(fileName)) {
            load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void save(OutputStream outputStream) throws Exception {
        prop.clear();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            prop.put (pair.getKey(), pair.getValue());
        }
        prop.store(outputStream,null);

    }

    public void load(InputStream inputStream) throws Exception {
        prop.load(inputStream);
        for (Map.Entry<Object, Object> pair: prop.entrySet()) {
            properties.put((String) pair.getKey(), (String) pair.getValue());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.fillInPropertiesMap();
        String fileName = "/Users/mhlv/Documents/test4";

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            s.save(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
