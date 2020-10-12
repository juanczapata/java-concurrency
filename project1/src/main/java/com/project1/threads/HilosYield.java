package com.project1.threads;

public class HilosYield {
    public static void main(String[] args) {
        Runnable task =  () -> {
            int counter = 0;
            while (counter < 3) {
                System.out.println(Thread.currentThread().getName());
                counter++;
                Thread.yield(); //Tells to the scheduler that another Thread with same or higher priority can use the processor, but it should be returned as soon as possible.
                //yield call can be ignored by the scheduler
            }
        };
        new Thread(task).start();
        new Thread(task).start();
    }
}
