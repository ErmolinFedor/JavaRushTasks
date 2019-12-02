package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));

        String file1 = br.readLine();
        String file2 = br.readLine();

        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);
        FileOutputStream fos1 = new FileOutputStream(file1);

        byte[] buf1 = new byte[fis1.available()];
        byte[] buf2 = new byte[fis2.available()];

        fis1.read(buf1);
        fis2.read(buf2);

        fis1.close();
        fis2.close();

        fos1.write(buf2);
        fos1.write(buf1);
        fos1.close();

    }
}
