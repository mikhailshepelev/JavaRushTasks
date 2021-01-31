package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    static int priority = 0;

    public MyThread() {
        definePriority();
    }

    public MyThread(Runnable target) {
        super(target);
        definePriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        definePriority();
    }

    public MyThread(String name) {
        super(name);
        definePriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        definePriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        definePriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        definePriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        definePriority();
    }

    private void definePriority() {
        if (priority + 1 > 10) {
            priority = 0;
        }

        priority++;
        if (this.getThreadGroup() != null && MyThread.priority + 1 > this.getThreadGroup().getMaxPriority()) {
            this.setPriority(this.getThreadGroup().getMaxPriority());
        } else {
            this.setPriority(priority);
        }
    }
}
