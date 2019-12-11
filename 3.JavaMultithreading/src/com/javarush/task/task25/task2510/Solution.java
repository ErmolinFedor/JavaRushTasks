package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {
        //Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public Solution() {
        //uncaughtExceptionHandler = new MyUncaughtExceptionHandler();
        //setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                } else if (e instanceof Throwable) {
                    System.out.println("Поживем - увидим");
                }else if (e instanceof Exception) {
                    System.out.println("Надо обработать");
                }

            }
        });
    }

    public static void main(String[] args) {
    }

}
