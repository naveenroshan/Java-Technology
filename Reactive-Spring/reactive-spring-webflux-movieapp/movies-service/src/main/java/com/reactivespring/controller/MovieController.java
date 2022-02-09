package com.reactivespring.controller;

import com.reactivespring.client.MovieInfoRestClient;
import com.reactivespring.client.MovieReviewRestClient;
import com.reactivespring.domain.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {

    private MovieInfoRestClient movieInfoRestClient;
    private MovieReviewRestClient movieReviewRestClient;

    public MovieController(MovieInfoRestClient movieInfoRestClient, MovieReviewRestClient movieReviewRestClient){
        this.movieInfoRestClient = movieInfoRestClient;
        this.movieReviewRestClient = movieReviewRestClient;
    }

    @GetMapping("/{id}")
    public Mono<Movie> retrieveMovieById (@PathVariable("id") String movieId){
        return movieInfoRestClient.retrieveMovieInfo(movieId)
                .flatMap(movieInfo -> {
                    var reviewListMono = movieReviewRestClient
                            .retrieveReviews(movieId).collectList();
                    return reviewListMono.map(reviews -> new Movie(movieInfo, reviews));
                });
    }
}
