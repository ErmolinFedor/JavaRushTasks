package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException {

        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        } else
            return "Your order: " + dishes + " of " + tablet;
    }

    public int getTotalCookingTime() {
        int i = 0;
        for (Dish dish : dishes) {
            i += dish.getDuration();
        }
        return i;
    }

    public boolean isEmpty() {
        if (dishes.isEmpty()) {
            return true;
        }
        return false;
    }
}
