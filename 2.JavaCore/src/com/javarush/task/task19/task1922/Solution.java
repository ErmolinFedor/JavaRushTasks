package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader( new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(console.readLine()));

        while (file.ready()){
            String line = file.readLine();
            String[] wordLine = line.split(" ");
            int count = 0;
            for (String word : wordLine){
                if (words.contains(word)) count++;
            }
            if (count == 2) System.out.println(line);
        }
        file.close();
        console.close();

    }
}
