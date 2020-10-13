package com.project1.threads.locks;

import java.util.concurrent.locks.ReentrantLock;

public class MainReentrantLock {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> accessResource()).start();
        }
    }
    static void accessResource() {
        reentrantLock.lock();
        System.out.println("Accessing ... " + Thread.currentThread().getName());
        reentrantLock.unlock();
    }
}
