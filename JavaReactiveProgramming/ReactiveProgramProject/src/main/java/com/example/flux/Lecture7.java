package com.example.flux;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture7 {
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepSec(5);
    }
}
