package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

public class Advertisement {

    private Object content;
    private String name;
    private long initialAmount; // начальная сумма, стоимость рекламы в копейках
    private int hits; // количество оплаченных показов
    private int duration; // продолжительность в секундах
    private long amountPerOneDisplaying; // стоимость одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        try {
            this.amountPerOneDisplaying = this.hits == 0 ? 0 : this.initialAmount / this.hits;
        } catch (ArithmeticException ex) {
            ConsoleHelper.writeMessage(ex.getMessage());
        }

    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public void revalidate() {
        if (this.hits == 0) {
            throw new UnsupportedOperationException();
        }
        this.hits --;
    }
}
