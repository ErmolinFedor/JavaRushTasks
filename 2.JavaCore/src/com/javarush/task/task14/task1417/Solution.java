package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        Money rub= new Ruble(100.0);
        Money uk = new Hrivna(123.0);
        Money us = new USD(500.0);
        List<Money> monies = new ArrayList<>();
        monies.add(rub);
        monies.add(uk);
        monies.add(us);
        ivan.setAllMoney(monies);
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;
        //public ArrayList<Money> allMoney;


        Person(String name) {
            this.name = name;
            //this.allMoney = new ArrayList<Money>();
            //напишите тут ваш код
        }

        private List<Money> allMoney;

        public void setAllMoney(List<Money> allMoney){
            this.allMoney = allMoney;
        }

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
