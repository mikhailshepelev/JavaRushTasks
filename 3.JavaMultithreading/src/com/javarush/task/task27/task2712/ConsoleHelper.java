package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {

        List<Dish> listOfDishes = new ArrayList<>();

        while (true) {
            System.out.println("Доступные блюда: " + Dish.allDishesToString());
            System.out.print("Введите блюдо: ");
            String input = reader.readLine();

            if (input.equals("exit")) {
                System.out.println("Заказ закончен.");
                break;
            }

            boolean dishExists = false;
            for (Dish dish : Dish.values()) {
                if (dish.name().equalsIgnoreCase(input)) {
                    dishExists = true;
                    listOfDishes.add(dish);
                    System.out.println("Блюдо успешно добавлено в заказ!");
                    break;
                }
            }

            if (!dishExists) {
                System.out.println("Выбранного Вами блюда нет в меню, попробуйте выбрать ещё раз");
            }
        }

        return listOfDishes;
    }
}
