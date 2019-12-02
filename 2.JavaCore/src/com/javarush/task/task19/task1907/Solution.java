package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        StringBuilder builder = new StringBuilder();

        int count = 0;

        while (fileReader.ready()){
            builder.append((char) fileReader.read());
        }

        String s = builder.toString();

        String[] parts = s.split("[^A-Za-z0-9]");

        for (int i = 0; i < parts.length; i++){
            if (parts[i].equals("world"))
                count++;
        }

        System.out.println(count);

        reader.close();
        fileReader.close();
    }
}
