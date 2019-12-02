package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readFile= new BufferedReader(new FileReader(args[0]));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(args[1]));

        StringBuilder sb = new StringBuilder();
        while (readFile.ready()){
            String line = readFile.readLine();
            String[] words = line.split(" ");
            for (String str : words){
                if (str.matches(".*\\d+.*")){
                    sb.append(str).append(" ");
                }
            }
        }
        writeFile.write(sb.toString());
        readFile.close();
        writeFile.close();
    }
}
