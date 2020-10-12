package com.project1.threads.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class MainClass {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, true);

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        IntStream.range(0,50).forEach((current) -> executorService.execute(new BasicTask(semaphore)));

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            System.out.println("...");
        }
        System.out.println("Task completed.");
    }
}
