package com.reactivespring.routes;

import com.reactivespring.domain.Review;
import com.reactivespring.exceptionHandler.GobalErrorHandler;
import com.reactivespring.handler.ReviewHandler;
import com.reactivespring.repo.ReviewReactiveRepo;
import com.reactivespring.router.ReviewRouter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static reactor.core.publisher.Mono.when;

@WebFluxTest
@ContextConfiguration(classes = {ReviewRouter.class,ReviewHandler.class, GobalErrorHandler.class})
@AutoConfigureWebTestClient
public class ReviewsUnitTest {


    @MockBean
    private ReviewReactiveRepo reviewReactiveRepo;

    @Autowired
    private WebTestClient webTestClient;

    static  String REVIEWS_URL = "/v1/reviews";

    @Test
    void addReview() {
        //given
        var review = new Review(null, 1L, "Awesome Movie", 9.0);
        when(reviewReactiveRepo.save(isA(Review.class)))
                .thenReturn(Mono.just(new Review("abc", 1L, "Awesome Movie", 9.0)));
        webTestClient
                .post()
                .uri(REVIEWS_URL)
                .bodyValue(review)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(Review.class)
                .consumeWith(movieInfoEntityExchangeResult -> {
                    var savedReview = movieInfoEntityExchangeResult.getResponseBody();
                    assert savedReview!=null;
                    assert savedReview.getReviewId()!=null;
                });
    }

    @Test
    void addReview_validation() {
        //given
        var review = new Review(null, null, "Awesome Movie", -9.0);

        when(reviewReactiveRepo.save(isA(Review.class)))
                .thenReturn(Mono.just(new Review("abc", 1L, "Awesome Movie", 9.0)));

        //when

        webTestClient
                .post()
                .uri(REVIEWS_URL)
                .bodyValue(review)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody(String.class)
                .isEqualTo("rating.movieInfoId : must not be null,rating.negative : please pass a non-negative value");
    }

    @Test
    void getAllReviews() {
        //given
        var reviewList = List.of(
                new Review(null, 1L, "Awesome Movie", 9.0),
                new Review(null, 1L, "Awesome Movie1", 9.0),
                new Review(null, 2L, "Excellent Movie", 8.0));
        when(reviewReactiveRepo.findAll()).thenReturn(Flux.fromIterable(reviewList));
        //when
        webTestClient
                .get()
                .uri("/v1/reviews")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(Review.class)
                .value(reviews -> {
                    assertEquals(3, reviews.size());
                });
    }

    @Test
    void updateReview() {
        //given
        var reviewUpdate = new Review(null, 1L, "Not an Awesome Movie", 8.0);
        when(reviewReactiveRepo.save(isA(Review.class))).thenReturn(Mono.just(new Review("abc", 1L, "Not an Awesome Movie", 8.0)));
        when(reviewReactiveRepo.findById((String) any())).thenReturn(Mono.just(new Review("abc", 1L, "Awesome Movie", 9.0)));
        //when
        webTestClient
                .put()
                .uri("/v1/reviews/{id}", "abc")
                .bodyValue(reviewUpdate)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Review.class)
                .consumeWith(reviewResponse ->{
                    var updatedReview = reviewResponse.getResponseBody();
                    assert updatedReview != null;
                    System.out.println("updatedReview : "+ updatedReview);
                    assertEquals(8.0,updatedReview.getRating());
                    assertEquals("Not an Awesome Movie", updatedReview.getComment());
                });
    }

    @Test
    void deleteReview() {
        //given
        var reviewId= "abc";
        when(reviewReactiveRepo.findById((String) any())).thenReturn(Mono.just(new Review("abc", 1L, "Awesome Movie", 9.0)));
        when(reviewReactiveRepo.deleteById((String) any())).thenReturn(Mono.empty());
        //when
        webTestClient
                .delete()
                .uri("/v1/reviews/{id}", reviewId)
                .exchange()
                .expectStatus().isNoContent();
    }
}
