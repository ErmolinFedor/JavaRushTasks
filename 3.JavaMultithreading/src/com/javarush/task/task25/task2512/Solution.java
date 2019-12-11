package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    private void loop(Throwable e){
        if (e != null)
           loop(e.getCause());
        if (e != null)
            System.out.println(e);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        loop(e);
    }

    public static void main(String[] args) {

        new Solution().uncaughtException(Thread.currentThread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
