package com.example.utility;

import com.github.javafaker.Faker;
import reactor.core.CoreSubscriber;

import java.util.function.Consumer;

public class Util {


    public static Consumer<Object> onNext(){
        return o -> System.out.println(o);
    }

    public static Consumer<Throwable> onError(){
        return e -> System.out.println(e.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("complete");
    }

    public static final Faker faker = Faker.instance();

    public static Faker faker(){
        return faker;
    }

    public static void sleepSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

}
