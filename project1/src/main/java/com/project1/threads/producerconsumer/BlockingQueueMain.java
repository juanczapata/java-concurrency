package com.project1.threads.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueMain {
    public static void main(String[] args) {
        BlockingQueue blockingQueue =  new ArrayBlockingQueue(4);

        Runnable producer = () -> {
            while (true) {
                System.out.println("Before adding item ... " + Thread.currentThread().getName());

                try {
                    blockingQueue.add(new Item());
                } catch (IllegalStateException ise) {
                    System.out.println("Queue is full, continuing...");
                    continue;
                }
                System.out.println("Adding item ... " + Thread.currentThread().getName());
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = () -> {
            while (true) {
                try {
                    System.out.println("Before adding item ... " + Thread.currentThread().getName());
                    blockingQueue.take();
                    System.out.println("Adding item ... " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("Queue is empty ... continuing");
                    continue;
                }
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
