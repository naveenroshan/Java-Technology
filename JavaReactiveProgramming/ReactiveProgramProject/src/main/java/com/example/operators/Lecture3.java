package com.example.operators;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

public class Lecture3 {
    // Limit Rate
    public static void main(String[] args) {
        Flux.range(1,1000)
                .log()
                // we are setting the limit rate to 95% or default is 75% or use 0 has low tide to drain all.
                .limitRate(100,95)
                .subscribe(Util.onNext());
    }
}
