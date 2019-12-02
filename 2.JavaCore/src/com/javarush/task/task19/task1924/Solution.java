package com.javarush.task.task19.task1924;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0 , "ноль");
        map.put(1 , "один");
        map.put(2 , "два");
        map.put(3 , "три");
        map.put(4 , "четыре");
        map.put(5 , "пять");
        map.put(6 , "шесть");
        map.put(7 , "семь");
        map.put(8 , "восемь");
        map.put(9 , "девять");
        map.put(10 , "десять");
        map.put(11 , "одиннадцать");
        map.put(12 , "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        String fileName = br.readLine();
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while (file.ready()){
            String line = file.readLine();
            String[] words = line.split(" ");
            for (String word : words){
                try {
                    int num = Integer.parseInt(word);
                    if (num>=0 && num<=12) System.out.print(map.get(num) + " ");
                    else System.out.print(num + " ");
                }catch (NumberFormatException e){
                    System.out.print(word + " ");
                }
            }
            System.out.println();
        }
        file.close();
        br.close();
    }
}
