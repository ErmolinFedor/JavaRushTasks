package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
       // System.out.println(hen.getCountOfEggsPerMonth());
       // System.out.println(hen.getDescription());
    }


    static class HenFactory {

        static Hen getHen(String country) {
            //System.out.println("factory: "+country);
            Hen hen = null;
            if(country.equalsIgnoreCase(Country.BELARUS)){
                hen = new BelarusianHen();
               // System.out.println("belarus don");
            }
            else if(country.equalsIgnoreCase(Country.MOLDOVA)) hen = new MoldovanHen();
            else if(country.equalsIgnoreCase(Country.RUSSIA)) hen = new RussianHen();
            else if (country.equalsIgnoreCase(Country.UKRAINE)) hen = new UkrainianHen();
            return hen;
        }
    }


}
