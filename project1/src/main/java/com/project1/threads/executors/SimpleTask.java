package com.project1.threads.executors;

import java.time.LocalDate;

public class SimpleTask implements Runnable {
    private int id;

    public SimpleTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(LocalDate.now());
        System.out.println("Running task : " + id + " Thread: " + Thread.currentThread().getName());
    }
}
