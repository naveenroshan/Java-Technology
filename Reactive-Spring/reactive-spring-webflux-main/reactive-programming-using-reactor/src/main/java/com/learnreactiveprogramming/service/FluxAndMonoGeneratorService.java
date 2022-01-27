package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FluxAndMonoGeneratorService {
    public Flux<String> namesFlus(){
        return Flux.fromIterable(List.of("ram", "jack", "mohan")).log();
    }

    public Flux<String> namesFlus_map(){
        return Flux.fromIterable(List.of("ram", "jack", "mohan"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> namesFlus_Filter(int stringlength){
        return Flux.fromIterable(List.of("ram", "jack", "mohan"))
                .filter(s->s.length()>stringlength)
                .log();
    }

    public Flux<String> namesFlus_FlatMap(){
        return Flux.fromIterable(List.of("mohan"))
                .flatMap(s->splitString(s))
                .log();
    }

    public Flux<String> namesFlus_FlatMap_Async(){
        return Flux.fromIterable(List.of("mohan"))
                .flatMap(s->splitStringdel(s))
                .log();
    }

    public Mono<String> namesMono(){
        return Mono.just("Ram").log();
    }

    public Mono<List<String>> namesMono_FlatMap(){
        return Mono.just("Ram")
                .flatMap(this::splitStringMono)
                .log();
    }

    private Mono<List<String>> splitStringMono(String s) {
        var charArray = s.split("");
        var chartList = List.of(charArray);
        return Mono.just(chartList);
    }

    public Flux<String> splitString(String name){
        var charArray= name.split("");
        return Flux.fromArray(charArray);
    }

    public Flux<String> splitStringdel(String name){
        var charArray= name.split("");
        var del = new Random().nextInt(1000);
        return Flux.fromArray(charArray).delayElements(Duration.ofMillis(del));
    }

    public Flux<String> namesFlus_ConcatMap(){
        return Flux.fromIterable(List.of("mohan")).concatMap(s->splitString(s)).log();
    }

    public Flux<String> namesMono_FlatMapMany(){
        return Mono.just("Ram")
                .flatMapMany(this::splitString)
                .log();
    }

    public Flux<String> namesFlux_Transform(int stringLength){
        Function<Flux<String>,Flux<String>> filtermap = name -> name.map(String::toUpperCase)
                .filter(s -> s.length()>stringLength);
        return Flux.fromIterable(List.of("mohann","ram","jack"))
                .transform(filtermap)
                .flatMap(s->splitString(s))
                .log();
    }

    public Flux<String> explore_concat(){
        var varFlux = Flux.just("A","B","C");
        var varFluxTwo = Flux.just("D","E","F");
        return Flux.concat(varFlux,varFluxTwo)
                .log();
    }

    public Flux<String> explore_merge(){
        var varFlux = Flux.just("A","B","C")
                .delayElements(Duration.ofMillis(100));
        var varFluxTwo = Flux.just("D","E","F")
                .delayElements(Duration.ofMillis(125));;
        return Flux.merge(varFlux,varFluxTwo)
                .log();
    }

    public Flux<String> explore_mergesequez(){
        var varFlux = Flux.just("A","B","C")
                .delayElements(Duration.ofMillis(100));
        var varFluxTwo = Flux.just("D","E","F")
                .delayElements(Duration.ofMillis(100));;
        return Flux.mergeSequential(varFlux,varFluxTwo)
                .log();
    }

    public Flux<String> explore_Zip(){
        var varFlux = Flux.just("A","B","C");
        var varFluxTwo = Flux.just("D","E","F");
        var varFluxTrid = Flux.just("1","2","3");
        return Flux.zip(varFlux,varFluxTwo,varFluxTrid)
               .map(t3 -> t3.getT3() + t3.getT2() + t3.getT1())
               .log();
    }

    public static void main(String[] arg){
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

        fluxAndMonoGeneratorService.namesFlus()
                .subscribe(name -> System.out.println("the stream of names: " + name));

        fluxAndMonoGeneratorService.namesMono()
                .subscribe(name -> System.out.println("the stream of name: " + name));
    }
}
