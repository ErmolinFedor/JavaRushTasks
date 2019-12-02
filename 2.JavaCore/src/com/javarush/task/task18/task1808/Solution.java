package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import javax.xml.transform.sax.SAXResult;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));

        try {
            FileInputStream fis1 = new FileInputStream(br.readLine());
            FileOutputStream fos2 = new FileOutputStream(br.readLine());
            FileOutputStream fos3 = new FileOutputStream(br.readLine());

            int fileSize = fis1.available();
            int part1Size = fileSize % 2 == 0 ? fileSize / 2 : fileSize / 2 + 1;

            while (fis1.available() > 0) {
                byte[] buf1 = new byte [part1Size];
                byte[] buf2 = new byte [fileSize - part1Size];

                fis1.read(buf1);
                fis1.read(buf2);
                fos2.write(buf1);
                fos3.write(buf2);
            }

            fis1.close();
            fos2.close();
            fos3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
