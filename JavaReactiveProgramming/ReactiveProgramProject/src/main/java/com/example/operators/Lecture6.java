package com.example.operators;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture6 {

    public static void main(String[] args) throws InterruptedException {
            getOrderNumber()
                    .timeout(Duration.ofSeconds(2), fallBack())
                    .subscribe(Util.onNext());
            Util.sleepSec(10);
    }
    private static Flux<Integer> getOrderNumber(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallBack(){
        return Flux.range(100,10)
                .delayElements(Duration.ofMillis(200));
    }
}
