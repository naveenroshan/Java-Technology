package com.example.flux;

import reactor.core.publisher.Flux;

public class Lecture2 {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1,2,3,4,5,6,7,8);
        Flux<Integer> evenFlux = integerFlux.filter(i -> i % 2 ==0);

        integerFlux.subscribe( i -> System.out.println("Sub 1 :" + i));
        evenFlux.subscribe(j -> System.out.println("Sub 2:" + j));
    }
}
