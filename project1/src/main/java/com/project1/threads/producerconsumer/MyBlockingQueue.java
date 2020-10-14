package com.project1.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    Queue<E> localQueue = new LinkedList<>();
    int queueSize;
    Lock localLock = new ReentrantLock();
    Condition notFull = localLock.newCondition();
    Condition notEmpty = localLock.newCondition();

    public MyBlockingQueue(int queueSize) {
        this.queueSize = queueSize;
    }

    public void add(E object) {
        localLock.lock();
        if (localQueue.size() == queueSize) {
            try {
                notFull.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Interrupted Exception while waiting for not full condition .... interrupting thread");
            }
        }
        localQueue.add(object);
        notEmpty.notifyAll();
        localLock.unlock();
    }

    public E take() throws InterruptedException {
        localLock.lock();
        E element = null;
        try {
            if (localQueue.isEmpty()) {
                notEmpty.await();
            }
            element =  localQueue.remove();
            notFull.notifyAll();

        } catch (InterruptedException e) {
            //Thread.currentThread().interrupt();
            System.out.println("Interrupted Exception while waiting for not empty condition .... interrupting thread");
            throw e;
        } finally {
            localLock.unlock();
        }
        return element;
    }
}
