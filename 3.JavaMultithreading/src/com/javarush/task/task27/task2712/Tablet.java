package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Logger;

public class Tablet extends Observable {

    private final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            advertisementManager.processVideos();
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);

                return order;
            }
        } catch (IOException ex) {
            logger.severe("Console is unavailable.");
        } catch (NoVideoAvailableException ex1) {
            logger.info("No video is available for the order " + order);
        }

        return null;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + this.number + "}";
    }
}
