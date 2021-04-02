package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private List<Advertisement> videos = new ArrayList<>();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {

        for (Advertisement ad : storage.list())
        {
            if (ad.getHits() > 0)
            {
                videos.add(ad);
            }
        }

        videos.sort((o1, o2) -> {
            int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
            if (result != 0) {
                return -result;
            }

            long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
            long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

            return Long.compare(oneSecondCost1, oneSecondCost2);
        });

        if (videos.isEmpty()) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }

        int totalTimeSpentToAds = 0;


        List<Advertisement> listForStatistics = new ArrayList<>();
        long totalSum = 0;

        for (Advertisement video : videos) {
            if (totalTimeSpentToAds + video.getDuration() > timeSeconds) {
                continue;
            }
            int oneSecondPrice = (int) (((double) video.getAmountPerOneDisplaying() / (double) video.getDuration()) * 1000);
            ConsoleHelper.writeMessage(video.getName() + " is displaying... "
                    + video.getAmountPerOneDisplaying() + ", " + oneSecondPrice);
            video.revalidate();
            listForStatistics.add(video);
            totalSum += video.getAmountPerOneDisplaying();
            totalTimeSpentToAds += video.getDuration();
        }

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(listForStatistics, totalSum, totalTimeSpentToAds));
    }
}
