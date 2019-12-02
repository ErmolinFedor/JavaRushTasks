package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Date;

/* 
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            //long start = 0;
            try {
                while (true){
                    Thread.sleep(1000);
                    seconds++;
                }
               // start = System.currentTimeMillis();
                //join();
            } catch (InterruptedException e) {
                //long stop = System.currentTimeMillis();
                //seconds = (int)(stop - start)/1000;
                System.out.println(seconds);
            }
        }
    }
}
