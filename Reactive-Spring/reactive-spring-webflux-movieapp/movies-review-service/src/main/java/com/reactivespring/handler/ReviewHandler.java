package com.reactivespring.handler;

import com.reactivespring.domain.Review;
import com.reactivespring.repo.ReviewReactiveRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ReviewHandler {

    private ReviewReactiveRepo reviewReactiveRepo;

    public ReviewHandler(ReviewReactiveRepo reviewReactiveRepo){
        this.reviewReactiveRepo = reviewReactiveRepo;
    }

    public Mono<ServerResponse> addReview(ServerRequest request) {

       return request.bodyToMono(Review.class)
                .flatMap(review -> {
                    return reviewReactiveRepo.save(review);
                })
                .flatMap(savedReview -> {
                    return ServerResponse.status(HttpStatus.CREATED)
                            .bodyValue(savedReview);
                })
               .log();
    }

    public Mono<ServerResponse> getReviewAll(ServerRequest request) {
        var reviewFlux = reviewReactiveRepo.findAll();
        return ServerResponse.ok().body(reviewFlux, Review.class);
    }

    public Mono<ServerResponse> updateReview(ServerRequest request) {
        var reviewId = request.pathVariable("id");
        var exisitingReview = reviewReactiveRepo.findById(reviewId);
        return exisitingReview
                .flatMap(review -> request.bodyToMono(Review.class)
                            .map(reqReview -> {
                                review.setComment(reqReview.getComment());
                                review.setRating(reqReview.getRating());
                                return  review;
                            })
                            .flatMap(reviewReactiveRepo::save)
                            .flatMap(saveReview -> ServerResponse.ok().bodyValue(saveReview)));
    }

    public Mono<ServerResponse> deleteReview(ServerRequest request) {
        var reviewId = request.pathVariable("id");
        var exisitingReview = reviewReactiveRepo.findById(reviewId);
        return exisitingReview
                .flatMap(review -> reviewReactiveRepo.deleteById(reviewId)
                        .then(ServerResponse.noContent().build()));
    }

}
