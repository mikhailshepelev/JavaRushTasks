package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet aTablet = new Tablet(1);

        Cook cook = new Cook("Amigo");
        aTablet.addObserver(cook);

        Waiter waiter = new Waiter();
        cook.addObserver(waiter);

        aTablet.createOrder();
    }
}
