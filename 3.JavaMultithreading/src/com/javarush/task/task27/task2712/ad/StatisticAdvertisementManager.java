package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    public Map<String, Integer> getActiveVideos() {
        Map<String, Integer> result = new TreeMap<>();

        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0) {
                result.put(advertisement.getName(), advertisement.getHits());
            }
        }
        return result;
    }

    public List<String> getArchiveVideos() {
        List<String> list = new ArrayList<>();
        for (Advertisement advertisement : storage.list()){
            if (advertisement.getHits() == 0){
                list.add(advertisement.getName());
            }
        }
        return list;
    }
}
