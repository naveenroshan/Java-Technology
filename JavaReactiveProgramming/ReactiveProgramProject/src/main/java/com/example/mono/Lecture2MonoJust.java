package com.example.mono;

import reactor.core.publisher.Mono;

public class Lecture2MonoJust {
    public static void main(String[] args) {
        //Publisher
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(i -> System.out.println(i));
    }
}
