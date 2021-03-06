package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        String sep = File.separator;
        Properties prop = new Properties();
        try {
            if (fileName.endsWith(".txt")) {
                prop.load(new FileReader(fileName));
            } else if (fileName.endsWith(".xml")) {
                prop.loadFromXML(new FileInputStream(fileName));
            } else {
                prop.load(new FileReader(fileName));
            }
        } catch (Exception e) {

        }
        return prop;
    }
}
