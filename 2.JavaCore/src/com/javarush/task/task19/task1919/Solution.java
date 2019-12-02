package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

        //show
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            // Хотелось как в условии задачи отформатировать, а нет валидатор думает иначе.
            //System.out.println(String.format("%s %.2f", pair.getKey(), pair.getValue()));
            System.out.println(pair.getKey()+" "+pair.getValue()); // - Так проходит
        }
    }


}