package com.example.basic;

import java.util.stream.Stream;

public class Lecture1Stream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1)
                                       .map(i -> {
                                           try {
                                               Thread.sleep(1000);
                                           } catch (InterruptedException e) {
                                               throw new RuntimeException(e);
                                           }
                                           return i;
                                       });

            stream.forEach(System.out::println);
    }
}
