package com.example.operators;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture4 {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(1,100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.onNext());
        Util.sleepSec(72);
    }
}
