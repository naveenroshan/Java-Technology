package com.example.operators;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

public class Lecture1 {
    //Handle operator
    public static void main(String[] args) {
        Flux.range(1,10)
                .handle((integer, synchronousSink) -> {
                    if(integer == 7){
                        synchronousSink.complete();
                    }else{
                        synchronousSink.next(integer);
                    }
                }).subscribe(Util.onNext());

        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
            .log()
            .map(Object::toString)
            .log()
            .handle((s,synchronousSink) ->{
                synchronousSink.next(s);
                if (s.toLowerCase().equals("canada"))
                    synchronousSink.complete();
            })
            .subscribe(Util.onNext());
    }
}
