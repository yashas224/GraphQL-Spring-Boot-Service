package com.graphql.app.graphql_app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchListInput {
    private Integer customerId;
    private Integer movieId;
}

