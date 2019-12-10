package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread thread;

    public LoggingStateThread(Thread thread){
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State state = State.TERMINATED;
        while (true){
            if (thread.getState() != state){
            switch (thread.getState()) {
                case NEW:
                    System.out.println("NEW");
                    state= State.NEW;
                    break;
                case RUNNABLE:
                    System.out.println("RUNNABLE");
                    state = State.RUNNABLE;
                    break;
                case BLOCKED:
                    System.out.println("BLOCKED");
                    state = State.BLOCKED;
                    break;
                case WAITING:
                    System.out.println("WAITING");
                    state = State.WAITING;
                    break;
                case TIMED_WAITING:
                    System.out.println("TIMED_WAITING");
                    state = State.TIMED_WAITING;
                    break;
                case TERMINATED:
                    System.out.println("TERMINATED");
                    return;
            }
                 //break;
            }
        }


    }
}
