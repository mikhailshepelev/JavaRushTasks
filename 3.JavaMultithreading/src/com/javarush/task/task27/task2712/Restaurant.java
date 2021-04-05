package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Cook aCook = new Cook("Amigo");
        Cook bCook = new Cook("Mike");
        aCook.setQueue(ORDER_QUEUE);
        bCook.setQueue(ORDER_QUEUE);

        List<Tablet> tablets = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Tablet tempTablet = new Tablet(i + 1);
            tempTablet.setQueue(ORDER_QUEUE);
            tablets.add(tempTablet);
        }

        Waiter waiter = new Waiter();
        aCook.addObserver(waiter);
        bCook.addObserver(waiter);

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread cookThread = new Thread(randomOrderGeneratorTask);
        cookThread.start();

        Thread cook1Thread = new Thread(aCook);
        cook1Thread.start();
        Thread cook2Thread = new Thread(bCook);
        cook2Thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        cookThread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();


    }
}
