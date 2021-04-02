package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.math.BigDecimal;
import java.util.Map;

public class DirectorTablet {

    public void printAdvertisementProfit(){
        Map<String, Long> map = StatisticManager.getInstance().getAdvertisementProfit();
        long totalSum = 0;

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                ConsoleHelper.writeMessage(entry.getKey() + " - " + new BigDecimal(entry.getValue()).movePointLeft(2));
                totalSum += entry.getValue();
            }
        }

        ConsoleHelper.writeMessage("Total - " + new BigDecimal(totalSum).movePointLeft(2));
    }

    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> map = StatisticManager.getInstance().getCookingTimeStatistics();

        for (Map.Entry<String, Map<String, Integer>> outerEntry : map.entrySet()) {
            if (outerEntry.getValue() != null) {
                ConsoleHelper.writeMessage(outerEntry.getKey());

                for (Map.Entry<String, Integer> innerEntry : outerEntry.getValue().entrySet()) {
                    if (innerEntry.getValue() != 0) {
                        ConsoleHelper.writeMessage(innerEntry.getKey() + " - " + innerEntry.getValue() + " min");
                    }
                }

                ConsoleHelper.writeMessage("");
            }
        }
    }

    public void printActiveVideoSet() {
        StatisticAdvertisementManager.getInstance().getActiveAds().forEach(ad -> ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits()));
    }

    public void printArchivedVideoSet() {
        StatisticAdvertisementManager.getInstance().getInactiveAds().forEach(ad -> ConsoleHelper.writeMessage(ad.getName()));
    }
}
