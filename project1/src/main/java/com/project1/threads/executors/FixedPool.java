package com.project1.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedPool {
    public static void main(String[] args) {
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            fixedExecutor.submit(new SimpleTask(i));
        }

        fixedExecutor.shutdown();

        while (!fixedExecutor.isTerminated()) {
        }
        System.out.println("Tasks completed.");

    }
}
