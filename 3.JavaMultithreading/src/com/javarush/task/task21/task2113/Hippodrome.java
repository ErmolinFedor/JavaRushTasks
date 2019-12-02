package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    private Hippodrome(){}

    public List<Horse> getHorses() {
        return horses;
    }

    public void run(){
        for (int i = 1; i <101 ; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void move(){
        for (Horse horse : horses)
            horse.move();
    }
    public void print(){
        for (Horse horse : horses)
            horse.print();
        /*for (int i = 0; i < 10 ; i++) {
            System.out.println();
        }*/
    }

    public Horse getWinner(){
        Horse winner = null;
        double res = 0;
        for ( Horse horse : horses){
            if (horse.getDistance()>res) {
                winner = horse;
                res = horse.getDistance();
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!" , getWinner().getName());
        //System.out.println("Winner is" + getWinner().getName() + "!");
    }

    public static void main(String[] args){
        Horse horse1 = new Horse("Green Lifs" , 3 ,0);
        Horse horse2 = new Horse("Sweet pumpking" , 3 ,0);
        Horse horse3 = new Horse("Black Dick" , 3 ,0);

        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }
}
