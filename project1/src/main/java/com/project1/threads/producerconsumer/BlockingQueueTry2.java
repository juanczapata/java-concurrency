package com.project1.threads.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTry2 {
    public static void main(String[] args) {
        //BlockingQueue blockingQueue = new ArrayBlockingQueue(4);
        MyBlockingQueue blockingQueue = new MyBlockingQueue(4);

        Runnable sender = () -> {
            while (true) {
                try {
                    blockingQueue.add(new Item());
                    System.out.println("Added element - " + Thread.currentThread().getName());
                } catch (IllegalStateException ex) {
                    System.out.println("There is no space in queue");
                }
            }
        };

        new Thread(sender).start();

        Runnable consumer =  () -> {
            while (true) {
                try {
                    blockingQueue.take();
                    System.out.println("consumed element - " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("Queue is empty");
                }
            }
        };

        new Thread(consumer).start();
    }
}
