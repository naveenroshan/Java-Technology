package com.example.operators;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

public class Lecture2 {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            System.out.println("inside create"); // -- fourth call
            for (int i=0; i<5; i++){
                fluxSink.next(i); // five call
            }
            fluxSink.complete(); // -- eight call
            System.out.println("--completed"); // -- nine call
        })
        .doOnComplete(() -> System.out.println("doOnComplete")) //-- six call
        .doFirst(() -> System.out.println("doFirst")) // -- zero call
        .doOnNext(o -> System.out.println("doOnNext : " + o)) // five call
        .doOnSubscribe(s-> System.out.println("doOnSubscribe :" + s)) // -- second call
        .doOnRequest(l -> System.out.println("doOnRequest :" + l)) // -- third call
        .doOnError(err -> System.out.println("doOnError :" + err)) // based on error
        .doOnTerminate(() -> System.out.println("doOnTerminate")) // -- seventh call
        .doOnCancel(() -> System.out.println("doOnCancel")) // based on the cancel
        .doFinally(signal -> System.out.println(signal))
        .take(3)
        .doOnDiscard(Object.class, o ->{
            System.out.println("doOnDiscard :" + o);
        })
        .subscribe(Util.onNext()); //-- first call
    }
}
