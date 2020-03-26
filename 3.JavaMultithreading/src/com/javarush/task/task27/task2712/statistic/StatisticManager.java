package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {

    private static StatisticManager ourInstance = new StatisticManager();
    //Список поваров
    Set<Cook> cooks = new LinkedHashSet<>();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {

    }

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Set<Cook> getCooks() {
        return cooks;
    }

    private class StatisticStorage {

        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {

            EventType[] eventTypes = EventType.values();

            for (EventType eventType : eventTypes) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }

    public Map<Date, Double> amountPerDay() {
        Map<Date, Double> result = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> eventDataRowList = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        double amount;
        Date date;
        Calendar calendar;
        for (EventDataRow eventDataRow : eventDataRowList) {
            VideoSelectedEventDataRow adVideo = (VideoSelectedEventDataRow) eventDataRow;
            amount = adVideo.getAmount()/100.0;
            calendar = Calendar.getInstance();
            calendar.setTime(adVideo.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            date = gc.getTime();
            if (result.containsKey(date))
                amount += result.get(date);
            result.put(date, amount);
        }
        return result;
    }

    public Map<Date, Map<String, Integer>> getCookPerAmount() {

        Map<Date, Map<String, Integer>> result = new TreeMap<>();
        List<EventDataRow> dataRows = statisticStorage.getStorage().get(EventType.COOKED_ORDER);

        for (EventDataRow eventDataRow : dataRows) {
            CookedOrderEventDataRow orderEventDataRow = (CookedOrderEventDataRow) eventDataRow;
            Date date = orderEventDataRow.getDate();

            Map<String, Integer> stringIntegerMap = new TreeMap<>();

            for (EventDataRow eventDataRow1 : dataRows) {
                CookedOrderEventDataRow orderEventDataRow1 = (CookedOrderEventDataRow) eventDataRow1;

                int time = orderEventDataRow1.getTime();
                String name = orderEventDataRow1.getCookName();

                if (orderEventDataRow.getDate() == date) {
                    if (!stringIntegerMap.containsKey(name)) {
                        stringIntegerMap.put(name, time);
                    } else {
                        int iTime = stringIntegerMap.get(name) + eventDataRow1.getTime();
                        stringIntegerMap.put(name, iTime);
                    }
                }
            }
            result.put(date, stringIntegerMap);
        }
        return result;
    }
}
