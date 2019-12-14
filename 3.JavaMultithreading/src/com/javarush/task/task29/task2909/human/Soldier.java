package com.javarush.task.task29.task2909.human;

public class Soldier extends Human{
    protected boolean isSoldier;
    //protected boolean isAlive;

    public Soldier(String name , int age){
        super(name , age);
    }

    public Soldier(boolean isSoldier) {
        super();
        this.isSoldier = isSoldier;
    }

    public void live() {
         fight();
    }

    public void fight() {
    }
}
