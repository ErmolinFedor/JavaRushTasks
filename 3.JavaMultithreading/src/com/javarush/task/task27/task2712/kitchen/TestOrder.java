package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {

        ConsoleHelper.writeMessage(Dish.allDishesToString());
        this.dishes = new ArrayList<>();
        for (Dish dish : Dish.values()){
            if ((int)(Math.random()* 2) == 1){
                dishes.add(dish);
            }
        }
    }


}
