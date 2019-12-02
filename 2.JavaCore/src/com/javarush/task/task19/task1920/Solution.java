package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader file = new BufferedReader(new FileReader(filename));

        while (file.ready()) {
            String s = file.readLine();
            String[] strs = s.split(" ");
            if (!map.containsKey(strs[0]))
                map.put(strs[0],Double.parseDouble(strs[1]));
            else
                map.put(strs[0], map.get(strs[0]) + Double.parseDouble(strs[1]));
        }

        file.close();

        double max = Collections.max(map.values());

        //show
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            // Хотелось как в условии задачи отформатировать, а нет валидатор думает иначе.
            //System.out.println(String.format("%s %.2f", pair.getKey(), pair.getValue()));
            if (pair.getValue() == max)System.out.println(pair.getKey()); // - Так проходит
        }
    }
}
