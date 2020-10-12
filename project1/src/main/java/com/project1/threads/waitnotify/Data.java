package com.project1.threads.waitnotify;

public class Data {
    public boolean waitForTransfer = true;
    private String packet;
    public synchronized void send(String message) {

        while (!waitForTransfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("thread " + Thread.currentThread().getName() + " interrupted");
            }
        }
        waitForTransfer = false;
        packet = message;
        notifyAll();
    }

    public synchronized String receive() {
        while (waitForTransfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("thread " + Thread.currentThread().getName() + " interrupted");
            }
        }
        waitForTransfer = true;
        notifyAll();
        return packet;
    }
}
