package com.example.operators;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture8 {
    //working with switch if Empty
    public static void main(String[] args) {
            getOrderNumber()
                    .filter(i -> i > 10)
                    .switchIfEmpty(fallBack())
                    .subscribe(Util.onNext());
    }

    private static Flux<Integer> getOrderNumber(){
        return Flux.range(1,10);
    }

    private static Flux<Integer> fallBack(){
        return Flux.range(100,10);
    }
}
