package com.reactivespring.repo;

import com.reactivespring.domain.MovieInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ActiveProfiles("test")
class MovieInfoRepoIntgTest {

    @Autowired
    MovieInfoRepo movieInfoRepo;

    @BeforeEach
    void setUp(){
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
    void tearDown(){
        movieInfoRepo.deleteAll().block();
    }

    @Test
    void findAll(){
        var moviesInfoFlux = movieInfoRepo.findAll().log();
        StepVerifier.create(moviesInfoFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void findbyId(){
        var moviesInfoMono = movieInfoRepo.findById("abc").log();
        StepVerifier.create(moviesInfoMono)
                .assertNext(movieInfo -> {
                    assertEquals("Dark Knight Rises",movieInfo.getName());
                })
                .verifyComplete();
    }

    @Test
    void updateMovieInfo(){
        var moviesInfo = movieInfoRepo.findById("abc").block();
        moviesInfo.setYear(2021);
        var movieInfoMono = movieInfoRepo.save(moviesInfo).log();
        StepVerifier.create(movieInfoMono)
                .assertNext(movieInfo -> {
                    assertEquals(2021,movieInfo.getYear());
                })
                .verifyComplete();
    }

    @Test
    void findByYear(){
        var moviesInfoFlux = movieInfoRepo.findByYear(2005).log();
        StepVerifier.create(moviesInfoFlux)
                .expectNextCount(1)
                .verifyComplete();
    }

}