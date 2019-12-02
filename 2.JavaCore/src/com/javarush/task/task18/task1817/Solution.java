package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);
        int countB = 0;
        int countL = 0;

        while (fis.available()>0){
            if (Character.isWhitespace(fis.read())) countB++;
            countL++;
        }
        fis.close();
        System.out.print(String.format("%.2f" , (float) countB / countL *100));

    }
}
