package com.reactivespring.controller;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.repo.MovieInfoRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.util.UriComponentsBuilder;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class MovieInfoControllerIntgTest {

    @Autowired
    MovieInfoRepo movieInfoRepo;

    @Autowired
    WebTestClient webTestClient;

    static String Movie_url= "/v1/movieinfos";

    @BeforeEach
    void setUp() {
        var movieinfos = List.of(new MovieInfo(null, "Batman Begins",
                        2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15")),
                new MovieInfo(null, "The Dark Knight",
                        2008, List.of("Christian Bale", "HeathLedger"), LocalDate.parse("2008-07-18")),
                new MovieInfo("abc", "Dark Knight Rises",
                        2012, List.of("Christian Bale", "Tom Hardy"), LocalDate.parse("2012-07-20")));
        movieInfoRepo.saveAll(movieinfos)
                .blockLast();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addMovieInfo() {
        var movieInfo = new MovieInfo(null, "Batman Begins test",
                2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        webTestClient
                .post()
                .uri(Movie_url)
                .bodyValue(movieInfo)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(MovieInfo.class)
                .consumeWith(movieInfoEntityExchangeResult -> {
                    var savedMovieInfo = movieInfoEntityExchangeResult.getResponseBody();
                    assert savedMovieInfo != null;
                    assert savedMovieInfo.getMoviesInfoId() != null;
                });
    }

    @Test
    void getAllmovieInfos(){
        webTestClient
                .get()
                .uri(Movie_url)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(MovieInfo.class)
                .hasSize(3);
    }

    @Test
    void getAllmovieInfosById(){
        var movieInfoId = "abc";
        webTestClient
                .get()
                .uri(Movie_url + "/{id}", movieInfoId)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(MovieInfo.class)
                .consumeWith(movieInfoEntityExchangeResult -> {
                    var savedMovieInfo = movieInfoEntityExchangeResult.getResponseBody();
                    assertNotNull(savedMovieInfo);
                });
    }

    @Test
    void updateMoviesInfosById() {
        var movieInfoId = "abc";
        var movieInfo = new MovieInfo(null, "Dark Knight Rises test update",
                2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        webTestClient
                .put()
                .uri(Movie_url + "/{id}", movieInfoId)
                .bodyValue(movieInfo)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(MovieInfo.class)
                .consumeWith(movieInfoEntityExchangeResult -> {
                    var updateMovieInfo = movieInfoEntityExchangeResult.getResponseBody();
                    assert updateMovieInfo != null;
                    assert updateMovieInfo.getMoviesInfoId() != null;
                    assertEquals("Dark Knight Rises test update",updateMovieInfo.getName());
                });
    }

    @Test
    void updateMoviesInfosById_NotFound() {
        var movieInfoId = "def";
        var movieInfo = new MovieInfo(null, "Dark Knight Rises test update",
                2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        webTestClient
                .put()
                .uri(Movie_url + "/{id}", movieInfoId)
                .bodyValue(movieInfo)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void deleteMoviesInfosById(){
        var movieInfoId = "abc";
        webTestClient
                .delete()
                .uri(Movie_url + "/{id}", movieInfoId)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(MovieInfo.class)
                .consumeWith(movieInfoEntityExchangeResult -> {
                    var savedMovieInfo = movieInfoEntityExchangeResult.getResponseBody();
                    assertNull(savedMovieInfo);
                });
    }

    @Test
    void getMovieInfoByYear(){
        var uri = UriComponentsBuilder.fromUriString(Movie_url)
                                           .queryParam("year", 2005)
                                           .buildAndExpand().toUri();
        webTestClient
                .get()
                .uri(uri)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(MovieInfo.class)
                .hasSize(1);
    }
}