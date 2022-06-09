package com.example.operators;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture7 {
    // working with default If Empty
    public static void main(String[] args) {
        getOrderNumber()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(Util.onNext());
    }

    private static Flux<Integer> getOrderNumber(){
        return Flux.range(1,14);
    }
}
