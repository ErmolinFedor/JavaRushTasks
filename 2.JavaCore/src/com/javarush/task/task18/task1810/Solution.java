package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
            while (true) {
                BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
                FileInputStream fis = new FileInputStream(br.readLine());

                int size = fis.available();
                fis.close();
                if (size<1000) throw new DownloadException();
            }
    }

    public static class DownloadException extends Exception {

    }
}
