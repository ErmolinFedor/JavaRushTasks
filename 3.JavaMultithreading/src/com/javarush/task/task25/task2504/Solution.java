package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thread : threads){
            switch (thread.getState()){
                //BLOCKED
                //Thread state for a thread blocked waiting for a monitor lock.
                //NEW
                //Thread state for a thread which has not yet started.
                //RUNNABLE
                //Thread state for a runnable thread.
                //TERMINATED
                //Thread state for a terminated thread.
                //TIMED_WAITING
                //Thread state for a waiting thread with a specified waiting time.
                //WAITING
                case NEW: thread.start();
                    break;
                case RUNNABLE: thread.isInterrupted();
                    break;
                case BLOCKED: thread.interrupt();
                    break;
                case WAITING: thread.interrupt();
                    break;
                case TIMED_WAITING: thread.interrupt();
                    break;
                case TERMINATED: System.out.println(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
