package com.example.mono;

import com.example.utility.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lecture06SupplierRefactor {
    public static void main(String[] args) throws InterruptedException {
        // to make it non blocking
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        getName();
        getName();
        Util.sleepSec(5);
    }

    private static Mono<String> getName(){
        System.out.println("Enter getName methode");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            try {
                Util.sleepSec(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    };
}
