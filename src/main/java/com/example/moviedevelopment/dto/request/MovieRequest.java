package com.example.moviedevelopment.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRequest {

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Director cannot be blank")
    private String director;

    @NotNull(message = "Release year is required")
    @Min(value = 1888, message = "Release year must be after 1888")
    private Integer releaseYear;

    @NotBlank(message = "Genre cannot be blank")
    private String genre;

    @NotNull(message = "IMDb rating is required")
    @DecimalMin(value = "0.0", message = "IMDb rating must be at least 0")
    @DecimalMax(value = "10.0", message = "IMDb rating cannot be more than 10")
    private Float imdbRating;

}