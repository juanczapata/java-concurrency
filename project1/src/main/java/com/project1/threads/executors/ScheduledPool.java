package com.project1.threads.executors;

import com.project1.threads.semaphore.BasicTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(4);

        for (int i = 0; i < 10; i++) {
            scheduledExecutor.scheduleAtFixedRate(new SimpleTask(i), 5L, 10L, TimeUnit.SECONDS);
            // Tasks will be added to the pool and will be executed endlessly
        }

    }
}
