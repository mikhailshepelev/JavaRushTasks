package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public int getTotalCookingTime() {
        int totalTime = 0;

        for (Dish dish : this.dishes) {
            totalTime += dish.getDuration();
        }

        return totalTime;
    }

    public boolean isEmpty() {
        return this.dishes.isEmpty();
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {

        if (this.dishes.isEmpty()) {
            return "";
        }
        return "Your order: " + dishes.toString() + " of " + this.tablet.toString()
                + ", cooking time " + getTotalCookingTime() + "min";
    }
}
