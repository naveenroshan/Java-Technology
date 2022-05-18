package com.example.flux;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Stream;

public class Lecture4 {
    public static void main(String[] args) {
        List<Integer> listWithIteam = List.of(1,2,3,4,5);
       // Stream<Integer> stream = listWithIteam.stream();

        Flux<Integer> integerFlux = Flux.fromStream(listWithIteam::stream);

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        System.out.println("Second Sub... can also access the same stream");
        System.out.println();
        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
