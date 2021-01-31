package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {

        static AtomicInteger numberOfFactories = new AtomicInteger(0);

        AtomicInteger factoryNumber;
        AtomicInteger threadNumber;

        public AmigoThreadFactory() {
            numberOfFactories.incrementAndGet();
            this.factoryNumber = numberOfFactories;
            threadNumber = new AtomicInteger(0);
        }

        @Override
        public Thread newThread(Runnable r) {
            threadNumber.incrementAndGet();
            Thread thread = new Thread(r);
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            thread.setName(String.format("%s-pool-%s-thread-%s", thread.getThreadGroup().getName(), factoryNumber.toString(), threadNumber.toString()));
            return thread;
        }
    }
}
