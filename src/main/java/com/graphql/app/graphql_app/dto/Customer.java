package com.graphql.app.graphql_app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
  private Integer id;
  private String name;
  private Genre favoriteGenre;
  List<Integer> watchList;
}


