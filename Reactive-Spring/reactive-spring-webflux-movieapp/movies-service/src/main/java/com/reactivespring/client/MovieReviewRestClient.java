package com.reactivespring.client;

import com.reactivespring.domain.Review;
import com.reactivespring.exception.ReviewsClientException;
import com.reactivespring.exception.ReviewsServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MovieReviewRestClient {

    private WebClient webClient;

    public MovieReviewRestClient(WebClient webClient){
        this.webClient =webClient;
    }

    @Value("${restClient.MoviesReviewUrl}")
    private String moviesReviewUrl;

    public Flux<Review> retrieveReviews(String movieId){
        var url = UriComponentsBuilder.fromHttpUrl(moviesReviewUrl)
                .queryParam("movieInfoId", movieId)
                .buildAndExpand()
                .toUriString();
        System.out.println("RestClient Review URL: " + url);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                    log.info("Status code is :" + clientResponse.statusCode().value());
                    if(clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)){
                        return Mono.empty();
                    }else {
                        return clientResponse.bodyToMono(String.class)
                                .flatMap(responseMessage ->
                                        Mono.error(new ReviewsClientException(responseMessage)));
                    }
                })
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
                    log.info("Status code is :" + clientResponse.statusCode().value());
                    return clientResponse.bodyToMono(String.class)
                            .flatMap(responseMessage ->
                                    Mono.error(new ReviewsServerException("Server Exception in moviesReviewService :" + responseMessage)));
                })
                .bodyToFlux(Review.class);
    }
}
