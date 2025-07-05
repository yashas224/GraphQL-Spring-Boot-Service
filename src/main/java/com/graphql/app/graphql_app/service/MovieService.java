package com.graphql.app.graphql_app.service;

import com.graphql.app.graphql_app.dto.Genre;
import com.graphql.app.graphql_app.dto.Movies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class MovieService {

  private final WebClient webClient;

  public MovieService(@Value("${movie-service-url}") String movieServiceUrl) {
    this.webClient = WebClient.builder().baseUrl(movieServiceUrl).build();
  }

  public Flux<Movies> moviesByGenre(Genre genre) {
    return webClient
       .get()
       .uri("/{genre}/recommended", genre)
       .retrieve()
       .bodyToFlux(Movies.class);
  }

  public Flux<Movies> moviesById(List<Integer> integerList) {
    return webClient
       .get()
       .uri(uriBuilder -> uriBuilder.queryParam("ids", integerList).build())
       .retrieve()
       .bodyToFlux(Movies.class);
  }
}
