package com.example.flux;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lecture3 {
    public static void main(String[] args) {
        List<String> string = Arrays.asList("a", "b", "c");

        Flux.fromIterable(string).subscribe(Util.onNext());

        Integer[] arr = {1,2,3,4};

        Flux.fromArray(arr).subscribe(Util.onNext());
    }
}
