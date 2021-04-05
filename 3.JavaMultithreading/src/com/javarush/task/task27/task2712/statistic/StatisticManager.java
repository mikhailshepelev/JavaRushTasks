package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager instance = null;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance(){
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<String, Long> getAdvertisementProfit() {
        List<EventDataRow> list = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        Map<String, Long> map = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow eventDataRow : list) {
            String tempDate = convertDateToString(eventDataRow.getDate());
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            if (map.containsKey(tempDate)) {
                map.replace(tempDate, map.get(tempDate) + videoSelectedEventDataRow.getAmount());
            } else {
                map.put(tempDate, videoSelectedEventDataRow.getAmount());
            }
        }
        return map;
    }

    public Map<String, Map<String, Integer>> getCookingTimeStatistics() {
        List<EventDataRow> list = statisticStorage.getStorage().get(EventType.COOKED_ORDER);
        Map<String, Map<String, Integer>> resultMap = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow eventDataRow : list) {
            String tempDate = convertDateToString(eventDataRow.getDate());
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;
            if (!resultMap.containsKey(tempDate)) {
                resultMap.put(tempDate, new TreeMap<>());
            }
            handleCooksMap(cookedOrderEventDataRow, resultMap.get(tempDate));
        }

        return resultMap;
    }

    private void handleCooksMap(CookedOrderEventDataRow cookedOrderEventDataRow, Map<String, Integer> cooksMap) {
        if (cooksMap.containsKey(cookedOrderEventDataRow.getCookName())) {
            cooksMap.replace(cookedOrderEventDataRow.getCookName(), cooksMap.get(cookedOrderEventDataRow.getCookName()) + (cookedOrderEventDataRow.getTime()/60));
        } else {
            cooksMap.put(cookedOrderEventDataRow.getCookName(), (cookedOrderEventDataRow.getTime()/60));
        }
    }

    private String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return dateFormat.format(date);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            Arrays.asList(EventType.values())
                    .forEach(eventType -> storage.put(eventType, new ArrayList<EventDataRow>()));
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}
