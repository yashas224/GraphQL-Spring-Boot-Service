package com.graphql.app.graphql_app.service;

import com.graphql.app.graphql_app.dto.Customer;
import com.graphql.app.graphql_app.dto.CustomerInput;
import com.graphql.app.graphql_app.dto.WatchListInput;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CustomerService {

  private final WebClient webClient;

  public CustomerService(@Value("${customer-service-url}") String customerServiceUrl) {
    this.webClient = WebClient.builder().baseUrl(customerServiceUrl).build();
  }

  @PostConstruct
  private void initCustomerService() {
    System.out.println("init CustomerService");
  }

  public Mono<Customer> geCustomer(int id) {
    return webClient.get()
       .uri("/{id}", id)
       .retrieve()
       .bodyToMono(Customer.class);
  }

  public Mono<Customer> updateCustomer(CustomerInput customerInput) {
    return webClient.put()
       .uri("/{id}", customerInput.getId())
       .bodyValue(customerInput)
       .retrieve()
       .bodyToMono(Customer.class);
  }

  public Mono<List<Integer>> addWatchLost(WatchListInput watchListInput) {
    return webClient.post()
       .uri("/watchlist")
       .bodyValue(watchListInput)
       .retrieve()
       .bodyToFlux(Integer.class)
       .collectList();
  }
}
