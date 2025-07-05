package com.graphql.app.graphql_app.dto;

import lombok.Data;

@Data
public class Movies {
    private Genre genre;
    private Integer id;
    private Integer rating;
    private Integer releaseYear;
    private String title;
}
