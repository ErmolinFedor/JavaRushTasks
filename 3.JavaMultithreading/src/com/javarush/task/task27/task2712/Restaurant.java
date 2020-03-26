package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;

    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {

        Cook[] cooks =  {new Cook("Amigo"), new Cook("Diego")};
        List<Cook> cookList = new LinkedList<>();

        //OrderManager orderManager = new OrderManager();

        for (Cook cook : cooks){
            cookList.add(cook);
        }

        List<Tablet> tablets = new LinkedList<>();
        Waiter waiter = new Waiter();

        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            for (int j = 0; j < cookList.size(); j++) {
                StatisticManager.getInstance().register(cookList.get(j));
            }
           // tablet.addObserver(orderManager);
            tablets.add(tablet);
        }

        for (int i = 0; i < cookList.size(); i++) {
            cookList.get(i).addObserver(waiter);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
