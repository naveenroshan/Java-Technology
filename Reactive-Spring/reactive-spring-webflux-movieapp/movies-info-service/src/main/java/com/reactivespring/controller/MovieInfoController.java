package com.reactivespring.controller;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.service.MoviesInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class MovieInfoController {

    private MoviesInfoService moviesInfoService;

    public MovieInfoController (MoviesInfoService moviesInfoService){
        this.moviesInfoService = moviesInfoService;
    }

    @GetMapping("/movieinfos")
    public Flux<MovieInfo> getAllMoviesInfos(){
        return moviesInfoService.getAllMovieInfos()
                .log();
    }

    @GetMapping("/movieinfos/{id}")
    public Mono<MovieInfo> getAllMoviesInfosById(@PathVariable String id){
        return moviesInfoService.getAllMovieInfosId(id)
                .log();
    }

    @PostMapping("/movieinfos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovieInfo> addMovieInfo(@RequestBody @Valid MovieInfo movieInfo){
            return moviesInfoService.addMovieInfo(movieInfo)
                    .log();
    }

    @PutMapping("/movieinfos/{id}")
    public Mono<ResponseEntity<MovieInfo>> updateMoviesInfosById(@RequestBody MovieInfo updateMovieInfo, @PathVariable String id){
        return moviesInfoService.updateMovieInfosId(updateMovieInfo, id)
                .map(movieInfo -> {
                    return ResponseEntity.ok().body(movieInfo);
                })
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
                .log();
    }

    @GetMapping("/movieinfos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMoviesInfosById(@PathVariable String id){
        return moviesInfoService.deleteMoviesInfosById(id)
                .log();
    }
}
