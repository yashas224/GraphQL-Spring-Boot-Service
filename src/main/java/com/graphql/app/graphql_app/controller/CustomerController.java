package com.graphql.app.graphql_app.controller;

import com.graphql.app.graphql_app.dto.*;
import com.graphql.app.graphql_app.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@AllArgsConstructor
public class CustomerController {

  private CustomerService customerService;

  @QueryMapping
  public Mono<Customer> userProfile(@Argument(name = "id") int id) {
    return customerService.geCustomer(id);
  }

  @MutationMapping
  public Mono<Customer> updateProfile(@Argument CustomerInput customerInput) {
    return customerService.updateCustomer(customerInput);
  }

  @MutationMapping
  public Mono<WatchListResponse> addToWatchList(@Argument WatchListInput watchListInput) {
    return customerService.addWatchLost(watchListInput)
       .map(integerList -> new WatchListResponse(Status.SUCCESS, integerList));
  }
}
