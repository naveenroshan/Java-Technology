package com.example.operators;

import com.example.utility.Person;
import com.example.utility.Util;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lecture10 {
    public static void main(String[] args) {
            getPerson()
                    .switchOnFirst(((signal, personFlux) -> {
                        System.out.println("inside switch on first");
                        return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
                    })).subscribe(Util.onNext());
    }

    public static Flux<Person> getPerson(){
        return Flux.range(1,10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>,Flux<Person>> applyFilterMap(){
        return personFlux -> personFlux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p ->p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, person -> System.out.println("Not allowing : " + person));
    }
}
