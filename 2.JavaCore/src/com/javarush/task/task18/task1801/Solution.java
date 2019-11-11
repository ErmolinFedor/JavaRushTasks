package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Максимальный байт
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

        int max = 0;

        FileInputStream fis = new
                FileInputStream(file);
        while (fis.available()>0){
            int data = fis.read();
            if (data>max) max=data;
        }
        fis.close();
        System.out.println(max);
    }
}
