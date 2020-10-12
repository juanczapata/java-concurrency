package com.project1.threads.semaphore;

import java.util.concurrent.Semaphore;

public class BasicTask implements Runnable {

    Semaphore semaphore;

    public BasicTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("requesting permit: " + Thread.currentThread().getName() + " - " + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("permit obtained: " + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            System.out.println("Interrupted exception: " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
            System.out.println("permit released: " + Thread.currentThread().getName());
        }
    }
}
