package com.graphql.app.graphql_app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchListResponse {
  private Status status;
  private List<Integer> watchList;
}

