package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //для вывода message в консоль
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    //для чтения строки с консоли
    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        ConsoleHelper.writeMessage("Выберите блюда. Для завершения наберите 'exit'.");
        ConsoleHelper.writeMessage(Dish.allDishesToString());

        List<Dish> list = new ArrayList<>();
        while (true) {
            String dish = readString();
            if (dish.equals("exit")) {
                break;
            }
            if (dish.isEmpty()) {
                ConsoleHelper.writeMessage("Блюдо не выбрано");
            }
            boolean flag = false;
            for (Dish dish1 : Dish.values())
                if (dish1.name().equals(dish)) {
                    list.add(dish1);
                    flag = true;
                }
            if (!flag) {
                writeMessage("Такого блюда нет");
            }
        }
        return list;
    }
}