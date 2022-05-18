package com.example.mono;

import com.example.utility.Util;
import reactor.core.publisher.Mono;

public class Lecture3MonoSubcribe {
    public static void main(String[] args) {

        Mono<String> mono = Mono.just("Water");

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
