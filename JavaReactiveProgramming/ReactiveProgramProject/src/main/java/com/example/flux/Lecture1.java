package com.example.flux;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

public class Lecture1 {
    public static void main(String[] args) {
        //flux return mutiple Items
        Flux<Object> flux = Flux.just(1,2,3,"STRING", Util.faker().name().fullName());
                flux.subscribe(Util.onNext(),
                                Util.onError(),
                                Util.onComplete());
    }
}
