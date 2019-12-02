package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0] != null) {

            FileInputStream fis = new FileInputStream(args[0]);
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            alphabet += alphabet.toUpperCase();
            int count = 0;

            while (fis.available() > 0) {
                if (alphabet.indexOf(fis.read())>-1) count++;
            }
            fis.close();
            System.out.println(count);
        }
    }
}
