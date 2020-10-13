package com.project1.threads.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainReadWriteLock {

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        new Thread(() -> readResource()).start();
        new Thread(() -> readResource()).start();
        new Thread(() -> readResource()).start();
        new Thread(() -> writeResource()).start();
        new Thread(() -> writeResource()).start();
    }

    private static void readResource() {

        try {
            readLock.lock();
            System.out.println("Reading resource -" + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("unlocking read resource");
            readLock.unlock();
        }

    }

    private static void writeResource() {

        try {
            writeLock.lock();
            System.out.println("Writing resource -" + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Unlocking write lock");
            writeLock.unlock();
        }

    }
}