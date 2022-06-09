package com.example.operators;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

public class Lecture5 {
 // working with on error
    public static void main(String[] args) {
        Flux.range(1,10)
            .log()
            .map(i -> 10 / (5 - i))
            .onErrorReturn(0)
            .subscribe(Util.onNext());
    }
}
