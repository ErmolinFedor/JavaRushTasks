package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger prioryty =new AtomicInteger(0);

    private int setpriority(){
        prioryty.set(prioryty.incrementAndGet());
        if (prioryty.get() == 11){
            prioryty.set(1);
        }
        return prioryty.get();
    }

    private int setpriority(int max){
        prioryty.set(prioryty.incrementAndGet());
        if (prioryty.get() == 11){
            prioryty.set(1);
        }
        return prioryty.get()>max ? max : prioryty.get();
    }


    public MyThread() {
        super();
        this.setPriority(setpriority());
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(setpriority());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(setpriority(group.getMaxPriority()));
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(setpriority());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(setpriority(group.getMaxPriority()));
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(setpriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(setpriority(group.getMaxPriority()));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(setpriority(group.getMaxPriority()));
    }

   /* public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
        super(group, target, name, stackSize, inheritThreadLocals);
        this.setPriority(setpriority(group.getMaxPriority()));
    }*/
}
