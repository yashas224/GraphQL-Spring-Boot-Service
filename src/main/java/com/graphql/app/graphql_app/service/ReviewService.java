package com.graphql.app.graphql_app.service;

import com.graphql.app.graphql_app.dto.Review;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ReviewService {

  private final WebClient webClient;

  public ReviewService(@Value("${review-service-url}") String reviewServiceUrl) {
    this.webClient = WebClient.builder().baseUrl(reviewServiceUrl).build();
  }

  public Flux<Review> getReviews(int movieId) {
    return webClient
       .get()
       .uri("/{movieId}", movieId)
       .retrieve()
       .bodyToFlux(Review.class);
  }
}
