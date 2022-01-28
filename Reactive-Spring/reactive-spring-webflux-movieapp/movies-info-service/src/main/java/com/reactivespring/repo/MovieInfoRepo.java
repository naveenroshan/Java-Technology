package com.reactivespring.repo;

import com.reactivespring.domain.MovieInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieInfoRepo extends ReactiveMongoRepository<MovieInfo, String> {

}
