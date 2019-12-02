package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new FirstThread());
        threads.add(new SecondtThread());
        threads.add(new ThirdThread());
        threads.add(new FourThread());
        threads.add(new FiveThread());
    }

    public static void main(String[] args) {
    }

    public static class FirstThread extends Thread {
        public FirstThread(){
   //         start();
        }

        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class SecondtThread extends Thread {
        public SecondtThread(){
   //         start();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100000000);
            }catch (InterruptedException e){
                System.out.println( "InterruptedException");
            }
        }
    }

    public static class ThirdThread extends Thread {
        public ThirdThread(){
          //  start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class FourThread extends Thread implements Message{
        private boolean live = true;
        public FourThread(){
          //  start();
        }

        @Override
        public void showWarning() {
            live = false;
        }

        @Override
        public void run() {
            while (live){

            }
        }
    }

    public static class FiveThread extends Thread {
        public FiveThread(){
          //  start();
        }

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
            int sum = 0;
            try {
                String s = reader.readLine();
                while (!s.equals("N")){
                    sum+=Integer.parseInt(s);
                    s=reader.readLine();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println(sum);
        }
    }
}