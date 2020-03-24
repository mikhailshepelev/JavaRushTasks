package com.javarush.task.task16.task1632.threads;

public class ThirdThread extends Thread{

    private boolean isAlive = true;
    @Override
    public void run() {
        while (isAlive){
            System.out.println("Ура");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
