package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    public void initDishes() {
        for (int i = 0; i < 5; i++) {
            int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, Dish.values().length-1);
            dishes.add(Dish.values()[boundedRandomValue]);
        }
    }
}
