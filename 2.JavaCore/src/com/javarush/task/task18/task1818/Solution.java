package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));

        FileOutputStream fos1 = new FileOutputStream(br.readLine());
        FileInputStream fis2 = new FileInputStream(br.readLine());
        FileInputStream fis3 = new FileInputStream(br.readLine());

        byte[] b2 = new  byte[fis2.available()];
        byte[] b3 = new byte[fis3.available()];

        fis2.read(b2);
        fis3.read(b3);

        fos1.write(b2);
        fos1.write(b3);

        fos1.close();;
        fis2.close();
        fis3.close();

    }
}
