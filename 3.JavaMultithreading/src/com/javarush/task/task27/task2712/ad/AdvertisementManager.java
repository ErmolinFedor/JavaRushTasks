package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;
import java.util.stream.Collectors;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> optimalVideoSet = new ArrayList<>();
        List<Advertisement> iz = new ArrayList<>();
        for (Advertisement advertisement : storage.list())
            if (advertisement.getHits() > 0) {
                iz.add(advertisement);
            }

        Collections.sort(iz, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long pricePerVideoDiff = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (pricePerVideoDiff != 0) {
                    return (int) pricePerVideoDiff;
                } else {
                    return (int) (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                }
            }
        });

        int totalTime = timeSeconds;
        long amount = 0;
        int totalDuration = 0;

        for (Advertisement advertisement : iz) {
            if (advertisement.getDuration() <= totalTime) {
                optimalVideoSet.add(advertisement);
                totalTime -= advertisement.getDuration();
                amount += advertisement.getAmountPerOneDisplaying();
                totalDuration += advertisement.getDuration();
            }
        }

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(iz, amount, totalDuration));
        if (storage.list().isEmpty()){
            throw new NoVideoAvailableException();
        }

        for (Advertisement adVideo : optimalVideoSet) {

            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", adVideo.getName(),
                    adVideo.getAmountPerOneDisplaying(), adVideo.getAmountPerOneDisplaying() * 1000 / adVideo.getDuration()));
            adVideo.revalidate();
        }
    }
}
