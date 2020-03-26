package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit() {

        Map<Date, Double> advertisementProfit = StatisticManager.getInstance().amountPerDay();
        double totalAmount = 0;
        double amount;
        for (Map.Entry<Date, Double> entry : advertisementProfit.entrySet()) {
            amount = entry.getValue();
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%1$te-%1$tb-%1$tY - %2$.2f", entry.getKey(), amount));
            totalAmount += amount;
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", totalAmount));
    }


    public void printCookWorkloading() {

        Map<Date, Map<String, Integer>> stringIntegerMap = StatisticManager.getInstance().getCookPerAmount();

        for (Map.Entry entry : stringIntegerMap.entrySet()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String date = simpleDateFormat.format(entry.getKey());

            ConsoleHelper.writeMessage(date);

            Map<String, Integer> stringIntegerMap1 = (Map) entry.getValue();
            for (Map.Entry entry1 : stringIntegerMap1.entrySet()) {
                int i = (int) entry1.getValue();
                ConsoleHelper.writeMessage(entry1.getKey() + " - " + i / 60 + " min");
            }
        }
    }

    public void printActiveVideoSet() {
        Map<String, Integer> map = StatisticAdvertisementManager.getInstance().getActiveVideos();

        for (Map.Entry<String, Integer>entry : map.entrySet()){
            ConsoleHelper.writeMessage(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void printArchivedVideoSet() {
        List<String> list = StatisticAdvertisementManager.getInstance().getArchiveVideos();

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        for (String s : list){
            ConsoleHelper.writeMessage(s);
        }
    }
}
