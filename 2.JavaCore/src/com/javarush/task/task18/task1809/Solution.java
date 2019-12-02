package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));

        FileInputStream fis = new FileInputStream(br.readLine());
        FileOutputStream fos = new FileOutputStream(br.readLine());

        byte[] buffer = new byte[fis.available()];
        byte[] bufferOut = new byte[buffer.length];
        while (fis.available()>0){
            fis.read(buffer);

            for (int i = buffer.length - 1; i >= 0; i--)
                bufferOut[buffer.length - i - 1] = buffer[i];
            fos.write(bufferOut);
        }

        fis.close();
        fos.close();

    }
}
