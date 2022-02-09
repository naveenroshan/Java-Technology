package com.reactivespring.client;

import com.reactivespring.domain.Review;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

@Component
public class MovieReviewRestClient {

    private WebClient webClient;

    public MovieReviewRestClient(WebClient webClient){
        this.webClient =webClient;
    }

   // @Value("${restClient.MoviesReviewUrl}")
    private String moviesReviewUrl = "http://localhost:8081/v1/reviews";

    public Flux<Review> retrieveReviews(String moviesId){
        var url = UriComponentsBuilder.fromHttpUrl(moviesReviewUrl)
                .queryParam("movieInfoId", moviesId)
                .buildAndExpand()
                .toUriString();
        System.out.println("RestClient Review URL: " + url);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(Review.class);
    }
}
