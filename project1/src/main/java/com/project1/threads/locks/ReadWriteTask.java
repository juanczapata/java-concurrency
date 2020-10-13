package com.project1.threads.locks;

public class ReadWriteTask {
    private int id;

    public ReadWriteTask(int id) {
        this.id = id;
    }

    public void readResource() {
        System.out.println("Reading resource - task-" + id);
    }
    public void writeResource() {
        System.out.println("Writing resource - task-" + id);
    }
}
