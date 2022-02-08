package com.reactivespring.routes;

import com.reactivespring.domain.Review;
import com.reactivespring.repo.ReviewReactiveRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
public class ReviewsIntgTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    ReviewReactiveRepo reviewReactiveRepo;

    static String REVIEW_URL = "/v1/reviews";

    @BeforeEach
    void setUp(){
        var reviewList = List.of(
                                    new Review(null, 1L, "Awesome", 9.0),
                                    new Review(null, 2L, "Better", 5.0),
                                    new Review(null, 3L, "Not Good", 2.0));
        reviewReactiveRepo.saveAll(reviewList).blockLast();
    }

    @AfterEach
    void tearDown(){
        reviewReactiveRepo.deleteAll().block();
    }

    @Test
    void addReview(){
        var review = new Review(null, 1L,"great...", 8.0);
        webTestClient
                .post()
                .uri(REVIEW_URL)
                .bodyValue(review)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(Review.class)
                .consumeWith(movieReviewEntityExchangeResult ->{
                    var savedReview = movieReviewEntityExchangeResult.getResponseBody();
                    assert savedReview != null;
                    assert savedReview.getReviewId()!=null;
                });
    }

    @Test
    void getAllmovieReview(){
        webTestClient
                .get()
                .uri(REVIEW_URL)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(Review.class)
                .hasSize(3);
    }

    @Test
    void deleteMoviesReviewById(){
        var movieInfoId = "1";
        webTestClient
                .delete()
                .uri(REVIEW_URL + "/{id}", movieInfoId)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(Review.class)
                .consumeWith(movieInfoEntityExchangeResult -> {
                    var savedMovieInfo = movieInfoEntityExchangeResult.getResponseBody();
                    assertNull(savedMovieInfo);
                });
    }

    @Test
    void updateReview() {
        //given
        var review = new Review(null, 1L, "Awesome Movie", 9.0);
        var savedReview = reviewReactiveRepo.save(review).block();
        var reviewUpdate = new Review(null, 1L, "Not an Awesome Movie", 8.0);
        //when
        assert savedReview != null;
        webTestClient
                .put()
                .uri(REVIEW_URL+"/{id}", savedReview.getReviewId())
                .bodyValue(reviewUpdate)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Review.class)
                .consumeWith(reviewResponse -> {
                    var updatedReview = reviewResponse.getResponseBody();
                    assert updatedReview != null;
                    System.out.println("updatedReview : " + updatedReview);
                    assertNotNull(savedReview.getReviewId());
                    assertEquals(8.0, updatedReview.getRating());
                    assertEquals("Not an Awesome Movie", updatedReview.getComment());
                });
    }
}
