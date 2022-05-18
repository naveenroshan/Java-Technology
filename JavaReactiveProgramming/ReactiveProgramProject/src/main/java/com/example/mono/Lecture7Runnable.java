package com.example.mono;

import com.example.utility.Util;
import reactor.core.publisher.Mono;

public class Lecture7Runnable {
    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                           Util.onError(),
                           () -> {
                           System.out.println("process is done");
                });
    }

    private static Runnable timeConsumingProcess(){
        return () ->{
            try {
                Util.sleepSec(3);
                System.out.println("Task Done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
