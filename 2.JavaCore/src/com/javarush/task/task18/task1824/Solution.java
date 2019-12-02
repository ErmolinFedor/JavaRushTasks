package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static boolean live = true;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (live){
        try {
            Thread thread = new ReaderFile(br.readLine());
            thread.start();
            thread.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    public static class ReaderFile extends Thread {
        private String fileName;

        public ReaderFile(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                Solution.live = false;
                System.out.println(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
