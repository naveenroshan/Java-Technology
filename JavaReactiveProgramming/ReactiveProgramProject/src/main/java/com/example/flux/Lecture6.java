package com.example.flux;

import com.example.utility.NameGenerator;
import com.example.utility.Util;

import java.util.List;

public class Lecture6 {
    //flux vs List
    public static void main(String[] args) throws InterruptedException {

        //using list it take 5 sec since it work with blocking
//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        // using Flux it works with 0 time
        NameGenerator.getNamesFlux(5).subscribe(Util.onNext());
    }
}
