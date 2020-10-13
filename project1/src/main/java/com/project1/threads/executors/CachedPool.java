package com.project1.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedPool {

    private int id;

    public CachedPool(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        // Recommended for small tasks
        // It will create new threads as needed but it will reuse thread available and remove those that are not used for more that 60 seconds.
        for (int i = 0; i < 20; i++) {
            cachedExecutor.submit(new SimpleTask(i));
        }

        cachedExecutor.shutdown();
        while (!cachedExecutor.isTerminated()) {};

        System.out.println("Tasks completed");
    }
}
