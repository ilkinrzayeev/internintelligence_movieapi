package com.example.moviedevelopment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieResponse {
    private Long id;
    private String title;
    private String director;
    private Integer releaseYear;
    private String genre;
    private Float imdbRating;

}