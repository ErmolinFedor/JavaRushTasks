package com.javarush.task.task25.task2510;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof Error){
            System.out.println("Нельзя дальше работать");
        }

        else if (e instanceof Throwable){
            System.out.println("Поживем - увидим");
        }
        else if (e instanceof Exception){
            System.out.println("Надо обработать");
        }
    }
}
