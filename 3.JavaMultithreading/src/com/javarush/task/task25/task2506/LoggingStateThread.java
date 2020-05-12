package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State previousState = thread.getState();
        System.out.println(previousState);
        do {
            State currentState = thread.getState();
            if (previousState != currentState) {
                System.out.println(currentState);
                previousState = currentState;
            }
        } while (thread.getState() != State.TERMINATED);
        interrupt();
    }
}
