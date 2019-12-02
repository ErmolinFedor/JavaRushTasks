package com.javarush.task.task14.task1408;

public class RussianHen extends Hen{

    @Override
    public int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    public String getDescription() {
        //<getDescription() родительского класса> + <" Моя страна - Sssss. Я несу N яиц в месяц.">
        return super.getDescription() + " Моя страна - "+ Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
