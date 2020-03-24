package com.javarush.task.task16.task1632.threads;

import com.javarush.task.task16.task1632.Message;

public class FourthThread extends Thread implements Message {

    private boolean isAlive = true;

    @Override
    public void showWarning() {
        isAlive = false;
    }

    @Override
    public void run() {
        while (isAlive){
        }
    }
}
