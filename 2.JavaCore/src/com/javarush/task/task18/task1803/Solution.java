package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));

        String file = "";

        try {
            file = br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

        Map<Integer , Integer> mapData = new HashMap<>();

        FileInputStream fis = new
                FileInputStream(file);
        while (fis.available()>0){
            int data = fis.read();
            if (mapData.containsKey(data)){
                int count = mapData.get(data);
                ++count;
                mapData.put(data, count);
            }else {
            mapData.put(data,0);}
        }
        fis.close();
        int max = Collections.max(mapData.values());
        for (Map.Entry<Integer , Integer> pair : mapData.entrySet()){
            if (pair.getValue() == max){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
