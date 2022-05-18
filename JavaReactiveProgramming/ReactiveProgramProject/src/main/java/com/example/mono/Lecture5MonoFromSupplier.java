package com.example.mono;

import com.example.utility.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lecture5MonoFromSupplier {
    public static void main(String[] args) {
        // use just only when you have data already
       // Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = () -> getName();
        Mono<String> monosupplier = Mono.fromSupplier(stringSupplier);

        monosupplier.subscribe(
                Util.onNext()
        );

        Callable<String> stringCallable = () -> getName();
        Mono<String> monoCallable = Mono.fromCallable(stringCallable);

        monoCallable.subscribe(
                Util.onNext()
        );
    }

    private static String getName(){
        System.out.println("name...");
        return Util.faker().name().fullName();
    }
}
