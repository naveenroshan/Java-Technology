package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.List;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void namesFlux(){
        var namesFlux = fluxAndMonoGeneratorService.namesFlus();
        StepVerifier.create(namesFlux)
                .expectNext("ram", "jack", "mohan")
                .verifyComplete();
    }

    @Test
    void namesFlux_map(){
        var namesFlux_map = fluxAndMonoGeneratorService.namesFlus_map();
        StepVerifier.create(namesFlux_map)
                .expectNext("RAM", "JACK", "MOHAN")
                .verifyComplete();
    }

    @Test
    void namesFlux_Fliter(){
        int stringlenght = 3;
        var namesFlux_fliter = fluxAndMonoGeneratorService.namesFlus_Filter(stringlenght);
        StepVerifier.create(namesFlux_fliter)
                .expectNext("jack", "mohan")
                .verifyComplete();
    }

    @Test
    void namesFlus_FlatMap(){
        var namesFlux_FlatMap = fluxAndMonoGeneratorService.namesFlus_FlatMap();
        StepVerifier.create(namesFlux_FlatMap)
                .expectNext("m" ,"o", "h", "a", "n")
                .verifyComplete();
    }

    @Test
    void namesFlus_FlatMap_Async(){
        var namesFlux_FlatMap = fluxAndMonoGeneratorService.namesFlus_FlatMap_Async();
        StepVerifier.create(namesFlux_FlatMap)
                .expectNext("m" ,"o", "h", "a", "n")
                .verifyComplete();
    }

    @Test
    void namesFlus_ConcatMap(){
        var namesFlux_FlatMap = fluxAndMonoGeneratorService.namesFlus_ConcatMap();
        StepVerifier.create(namesFlux_FlatMap)
                .expectNext("m" ,"o", "h", "a", "n")
                .verifyComplete();
    }

    @Test
    void namesMono_FlatMap(){
        var namesMono_FlatMap = fluxAndMonoGeneratorService.namesMono_FlatMap();
        StepVerifier.create(namesMono_FlatMap)
                .expectNext(List.of("R","a","m"))
                .verifyComplete();
    }

    @Test
    void namesMono_FlatMapMany(){
        var namesMono_FlatMapMany = fluxAndMonoGeneratorService.namesMono_FlatMapMany();
        StepVerifier.create(namesMono_FlatMapMany)
                .expectNext("R","a","m")
                .verifyComplete();
    }

    @Test
    void namesFlux_Transform(){
        int stringLength = 4;
        var namesFlux_Transform = fluxAndMonoGeneratorService.namesFlux_Transform(stringLength);
        StepVerifier.create(namesFlux_Transform)
                .expectNext("M","O","H","A","N","N")
                .verifyComplete();
    }

    @Test
    void explore_concat(){
        var explore_concat = fluxAndMonoGeneratorService.explore_concat();
        StepVerifier.create(explore_concat)
                .expectNext("A","B","C","D","E","F")
                .verifyComplete();
    }

    @Test
    void explore_merge(){
        var explore_merge = fluxAndMonoGeneratorService.explore_merge();
        StepVerifier.create(explore_merge)
                .expectNext("A","D","B","E","C","F")
                .verifyComplete();
    }

    @Test
    void explore_mergesequez(){
        var explore_mergesequez = fluxAndMonoGeneratorService.explore_mergesequez();
        StepVerifier.create(explore_mergesequez)
                .expectNext("A","B","C","D","E","F")
                .verifyComplete();
    }

    @Test
    void explore_Zip(){
        var explore_Zip = fluxAndMonoGeneratorService.explore_Zip();
        StepVerifier.create(explore_Zip)
                .expectNext("1DA","2EB","3FC")
                .verifyComplete();
    }

}