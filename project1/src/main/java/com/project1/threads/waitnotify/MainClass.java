package com.project1.threads.waitnotify;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();

        List<Integer> sorteredLIst = Stream.of(25,5,2,30,10).sorted((a, b) -> { return (b > a)? 1:-1; }).collect(Collectors.toList());

        for (int curNumber :
                sorteredLIst) {
            System.out.println(curNumber);
        }

    }
}
