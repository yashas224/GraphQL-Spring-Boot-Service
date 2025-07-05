package com.graphql.app.graphql_app.controller;

import com.graphql.app.graphql_app.dto.Movies;
import com.graphql.app.graphql_app.dto.Review;
import com.graphql.app.graphql_app.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@AllArgsConstructor
public class ReviewController {
  private ReviewService reviewService;

  @SchemaMapping(typeName = "MovieDetails")
  public Flux<Review> review(Movies movie) {
    return reviewService.getReviews(movie.getId());
  }
}
