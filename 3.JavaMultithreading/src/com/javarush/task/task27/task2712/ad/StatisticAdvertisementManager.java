package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager instance= null;
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            instance = new StatisticAdvertisementManager();
        }
        return instance;
    }

    public Set<Advertisement> getActiveAds() {
        Set<Advertisement> activeAds = new TreeSet<>(Comparator.comparing(ad -> ad.getName().toLowerCase()));

        for (Advertisement ad : advertisementStorage.list()) {
            if (ad.getHits() > 0) {
                activeAds.add(ad);
            }
        }

        return activeAds;
    }

    public Set<Advertisement> getInactiveAds() {
        Set<Advertisement> inactiveAds = new TreeSet<>(Comparator.comparing(ad -> ad.getName().toLowerCase()));;

        for (Advertisement ad : advertisementStorage.list()) {
            if (ad.getHits() == 0) {
                inactiveAds.add(ad);
            }
        }

        return inactiveAds;
    }
}
