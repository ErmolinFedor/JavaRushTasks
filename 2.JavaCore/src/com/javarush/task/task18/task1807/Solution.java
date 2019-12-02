package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));

        FileInputStream fis = null;
        int count = 0;
        try {
            fis = new FileInputStream(br.readLine());
            while (fis.available() > 0){
                if((char)(fis.read())==',') count++;
            }
        fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
