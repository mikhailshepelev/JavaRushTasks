package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for(Thread t : threads) {
            Thread.State state = t.getState();
            switch (state) {
                case NEW :
                    t.start();
                    break;
                case TERMINATED:
                    System.out.println(t.getPriority());
                    break;
                case RUNNABLE:
                    t.isInterrupted();
                    break;
                case BLOCKED:
                case WAITING:
                case TIMED_WAITING:
                    t.interrupt();
                    break;
                default:
                    break;
            }
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
