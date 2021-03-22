package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {

    private static AdvertisementStorage instance = null;
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage(){
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
    }

    public static AdvertisementStorage getInstance(){
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }

    public List<Advertisement> list() {
        return this.videos;
    }

    public void add(Advertisement advertisement) {
        this.videos.add(advertisement);
    }
}
