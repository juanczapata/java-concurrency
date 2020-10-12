package com.project1.threads.waitnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        for (String message = load.receive() ; !"End".equals(message) ; message = load.receive()) {
            System.out.println("received message: " + message);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + Thread.currentThread().getName());
            }
        }
    }
}
