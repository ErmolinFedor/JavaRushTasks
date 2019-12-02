package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.ParseException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        String s ;
        while (!(s=br.readLine()).equals("exit")){
            try {
                if (s.contains(".")){
                double d = Double.parseDouble(s);
                print(d);}
                else {
                int i = Integer.parseInt(s);
                if(i>0 && i<128){
                    short sh = Short.parseShort(s);
                    print(sh);
                }
                else print(i);}
            }catch (Exception e){
                print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
