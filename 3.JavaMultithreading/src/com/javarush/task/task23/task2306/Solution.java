package com.javarush.task.task23.task2306;

/* 
Inner 2
*/
public class Solution {
    private String country;
    private String city;

    public Solution(String country, String city) {
        this.country = country;
        this.city = city;
    }

    /*т.к. модификатор иннер класса private, то чтобы вызвать метод getDescription из другого внешнего класса,
    нужно обернуть его вызов в какой-то public метод*/
    public String getUserDescription(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        //доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        public SuperUser(String name) {
            this.name = name;
        }

        //доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        //My name is George. I'm from Seattle in the United States.
        public String getDescription() {
            return String.format("My name is %s. I'm from %s in %s.", this.name, city , country);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution("the United States", "Seattle");
        //внутри класса Solution (а сейчас мы внутри) к методу getDescription можно обращаться обоими способами
        System.out.println(solution.getTrickyUser("George").getDescription());
        //а из любого другого внешнего класса только так:
        System.out.println(solution.getUserDescription("George"));
        System.out.println(solution.getTrickyUser("George").getDescription().equals("My name is George. I'm from Seattle in the United States."));
        System.out.println("My name is George. I'm from Seattle in the United States.");
    }
}
