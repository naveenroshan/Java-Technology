package com.reactivespring.service;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.repo.MovieInfoRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MoviesInfoService {

    private MovieInfoRepo movieInfoRepo;

    public MoviesInfoService(MovieInfoRepo movieInfoRepo ){
        this.movieInfoRepo = movieInfoRepo;
    }

    public Mono<MovieInfo> addMovieInfo(MovieInfo movieInfo){
         return movieInfoRepo.save(movieInfo);
    }

    public Flux<MovieInfo> getAllMovieInfos() { return movieInfoRepo.findAll(); }

    public Mono<MovieInfo> getAllMoviesInfosById(String id) {
        return  movieInfoRepo.findById(id);
    }

    public Mono<MovieInfo> updateMovieInfosId(MovieInfo updateMovieInfo, String id) {
        return  movieInfoRepo.findById(id)
                .flatMap(movieInfo -> {
                    movieInfo.setCast(updateMovieInfo.getCast());
                    movieInfo.setName(updateMovieInfo.getName());
                    movieInfo.setYear(updateMovieInfo.getYear());
                    movieInfo.setReleaseDate(updateMovieInfo.getReleaseDate());
                    return movieInfoRepo.save(movieInfo);
                });
    }

    public Mono<Void> deleteMoviesInfosById(String id) {
        return movieInfoRepo.deleteById(id);
    }

    public Flux<MovieInfo> getMoviesByYear(Integer year) {
        return movieInfoRepo.findByYear(year);
    }
}
