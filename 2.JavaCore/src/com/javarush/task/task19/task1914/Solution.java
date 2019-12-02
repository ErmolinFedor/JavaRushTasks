package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);



        //выводим ее в консоль
        String[] nums = result.split( " ");

        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[2]);
        int c = 0;
        switch (nums[1]){
            case "+" : c = a+b; break;
            case "-" : c = a-b; break;
            case "*" : c = a*b; break;
        }

        System.out.print(result.substring(0 , result.length()-2) + String.valueOf(c));
       // System.out.print(result.replaceAll("\\p{Cntrl}" , "") +String.valueOf(c)); //то же самое только через рег выражения
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

