package com.example.flux;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

public class Lecture5 {
    public static void main(String[] args) {

//        Flux.range(1,10)
//            .log()
//            .map(i -> Util.faker.name().fullName())
//            .log()
//            .subscribe(Util.onNext());

        Flux.range(3, 5)
                .map(i -> i / (i - 4))
                .subscribe(Util.onNext());
    }
}
