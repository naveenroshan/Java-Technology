package com.reactivespring.controller;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.service.MoviesInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@WebFluxTest(controllers = MovieInfoController.class)
@AutoConfigureWebTestClient
public class MoviesInfoConrollerUnitTest {

    static String Movie_url= "/v1/movieinfos";

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private MoviesInfoService moviesInfoServiceMock;

    @Test
    void getAllmovieInfo(){
        var movieinfos = List.of(new MovieInfo(null, "Batman Begins",
                        2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15")),
                new MovieInfo(null, "The Dark Knight",
                        2008, List.of("Christian Bale", "HeathLedger"), LocalDate.parse("2008-07-18")),
                new MovieInfo("abc", "Dark Knight Rises",
                        2012, List.of("Christian Bale", "Tom Hardy"), LocalDate.parse("2012-07-20")));
        when(moviesInfoServiceMock.getAllMovieInfos()).thenReturn(Flux.fromIterable(movieinfos));
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
    void getMovieInfoById() {
        when(moviesInfoServiceMock.getAllMoviesInfosById(anyString())).thenReturn(Mono.just(new MovieInfo("abc", "Dark Knight Rises",
                2012, List.of("Christian Bale", "Tom Hardy"), LocalDate.parse("2012-07-20"))));
        var movieId = "abc";
        webTestClient
                .get()
                .uri(Movie_url + "/{id}", movieId)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(MovieInfo.class)
                .consumeWith(movieInfoEntityExchangeResult -> {
                    var movieInfo = movieInfoEntityExchangeResult.getResponseBody();
                    assertNotNull(movieInfo);
                });;
    }

    @Test
    void addMovieInfo() {
        var movieInfo = new MovieInfo(null, "Batman Begins test",
                2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        when(moviesInfoServiceMock.addMovieInfo(isA(MovieInfo.class))).thenReturn(
                Mono.just(new MovieInfo("mockId", "Batman Begins test",
                        2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"))));
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
                    assertEquals("mockId",savedMovieInfo.getMoviesInfoId());
                });
    }

    @Test
    void addMovieInfo_Validation() {
        var movieInfo = new MovieInfo(null, "",
                -2005, List.of(""), LocalDate.parse("2005-06-15"));
        webTestClient
                .post()
                .uri(Movie_url)
                .bodyValue(movieInfo)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody(String.class)
                .consumeWith(stringEntityExchangeResult -> {
                    var savedMovieInfo = stringEntityExchangeResult.getResponseBody();
                    System.out.println("response Body: " + savedMovieInfo);
                    assert savedMovieInfo != null;
                });
    }

    @Test
    void updateMoviesInfosById() {
        var movieInfoId = "abc";
        var movieInfo = new MovieInfo(null, "Dark Knight Rises unittest update",
                2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        when(moviesInfoServiceMock.updateMovieInfosId(isA(MovieInfo.class),isA(String.class)).thenReturn(
                Mono.just(new MovieInfo(movieInfoId, "Dark Knight Rises unittest update",
                        2005, List.of("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15")))));
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
    void deleteMoviesInfosById(){
        var movieInfoId = "abc";
        when(moviesInfoServiceMock.deleteMoviesInfosById(isA(String.class))).thenReturn(Mono.empty());
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
}
