package com.example.flux;

import com.example.utility.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture8 {
    public static void main(String[] args) {
        //Flux from MONO
        Mono<String> mono = Mono.just("a");

        Flux<String> flux = Flux.from(mono);

        flux.subscribe(Util.onNext());

        //Mono from flux
        Flux.range(1, 5)
                .filter(i -> i > 3)
                .next()
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

}
