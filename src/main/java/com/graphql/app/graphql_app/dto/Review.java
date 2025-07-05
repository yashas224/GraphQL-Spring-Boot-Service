package com.graphql.app.graphql_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
  private String comment;
  private Integer id;
  private Integer rating;
  private String username;
}

