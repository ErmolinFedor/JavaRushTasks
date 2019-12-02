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

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();

        for (Map.Entry<String , String> pair : properties.entrySet()){
            Object key = pair.getKey();
            Object val = pair.getValue();
            prop.put(key , val);
        }
        prop.store(outputStream , "done");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties propertie = new Properties();
        propertie.load(inputStream);
        for (Map.Entry<Object , Object> prop : propertie.entrySet()){
            String key = (String) prop.getKey();
            String val = (String) prop.getValue();
            properties.put(key , val);
        }
    }

    public static void main(String[] args) {

    }
}
