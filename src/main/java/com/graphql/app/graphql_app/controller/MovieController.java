package com.graphql.app.graphql_app.controller;

import com.graphql.app.graphql_app.dto.Customer;
import com.graphql.app.graphql_app.dto.Genre;
import com.graphql.app.graphql_app.dto.Movies;
import com.graphql.app.graphql_app.dto.WatchListResponse;
import com.graphql.app.graphql_app.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@AllArgsConstructor
public class MovieController {
  private MovieService movieService;

  @SchemaMapping(typeName = "UserProfile")
  public Flux<Movies> watchList(Customer customer) {
    return !customer.getWatchList().isEmpty() ? movieService.moviesById(customer.getWatchList()) : Flux.empty();
  }

  @SchemaMapping(typeName = "UserProfile")
  public Flux<Movies> recommended(Customer customer) {
    return movieService.moviesByGenre(customer.getFavoriteGenre());
  }

  @QueryMapping
  public Mono<Movies> movieDetails(@Argument int id) {
    return movieService.moviesById(List.of(id)).next();
  }

  @QueryMapping
  public Flux<Movies> moviesByGenre(@Argument Genre genre) {
    return movieService.moviesByGenre(genre);
  }

  @SchemaMapping
  public Flux<Movies> watchList(WatchListResponse watchListResponse) {
    return movieService.moviesById(watchListResponse.getWatchList());
  }
}
