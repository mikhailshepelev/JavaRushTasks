package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public Hippodrome() {
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse h: horses) {
            h.move();
        }
    }

    public void print(){
        for (Horse h: horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse winner = new Horse("", 0, Double.MIN_VALUE);
        for (int i = 0; i<horses.size(); i++) {
            if(horses.get(i).getDistance()>winner.getDistance()) winner = horses.get(i);
        }
        return winner;
    }

    public void printWinner(){
        String name = getWinner().getName();
        System.out.println("Winner is " + name + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        Horse aHorse = new Horse("Ferrari", 3, 0);
        Horse bHorse = new Horse("Ford", 3, 0);
        Horse cHorse = new Horse("Mustang", 3, 0);
        game.horses.add(aHorse);
        game.horses.add(bHorse);
        game.horses.add(cHorse);
        game.run();
        game.printWinner();
    }
}
