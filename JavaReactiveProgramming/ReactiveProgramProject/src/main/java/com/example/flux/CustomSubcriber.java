package com.example.flux;

import com.example.utility.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.sql.SQLOutput;
import java.util.concurrent.atomic.AtomicReference;

public class CustomSubcriber {
    public static void main(String[] args) throws InterruptedException {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1,10)
            .log()
            .subscribeWith(new Subscriber<Integer>() {
                @Override
                public void onSubscribe(Subscription s) {
                    System.out.println("Received Sub : " + s);
                    atomicReference.set(s);
                }

                @Override
                public void onNext(Integer integer) {
                    System.out.println("on next : " + integer);
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("on error : " + t.getMessage());
                }

                @Override
                public void onComplete() {
                    System.out.println("on complete");
                }
            });

        //above step we are calling request method on to the publiser to get the value since we are using custom subcribtion
        //but normal way it will automatically internal system will do the request.
        Util.sleepSec(5);
        atomicReference.get().request(3);

        Util.sleepSec(3);
        atomicReference.get().request(3);

        Util.sleepSec(3);
        System.out.println("going to drop");

        Util.sleepSec(3);
        atomicReference.get().cancel();

        Util.sleepSec(3);
        System.out.println("no out put since it got dropped....");
        atomicReference.get().request(3);

    }
}
