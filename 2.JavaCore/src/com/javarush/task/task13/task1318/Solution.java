package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        String fileName = "";
        try {
            fileName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream inStream = null;
        try {
            inStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (inStream.available() > 0)
        {
            int data = inStream.read(); //читаем один int из потока для чтения
            System.out.print((char) data); //записываем прочитанный int в другой поток.
        }

        inStream.close();
        br.close();

    }
}