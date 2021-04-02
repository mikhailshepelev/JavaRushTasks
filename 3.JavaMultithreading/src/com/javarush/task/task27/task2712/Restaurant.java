package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws InterruptedException {
        Cook aCook = new Cook("Amigo");
        Cook bCook = new Cook("Mike");

        StatisticManager.getInstance().register(aCook);
        StatisticManager.getInstance().register(bCook);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tempTablet = new Tablet(i + 1);
            tempTablet.addObserver(aCook);
            tempTablet.addObserver(bCook);
            tablets.add(tempTablet);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

        Waiter waiter = new Waiter();
        aCook.addObserver(waiter);

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}
