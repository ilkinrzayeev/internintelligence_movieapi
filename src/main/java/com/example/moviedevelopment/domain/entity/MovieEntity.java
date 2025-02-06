package com.example.moviedevelopment.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movies")
@Data
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "director", nullable = false, length = 50)
    private String director;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    @Column(name = "genre", nullable = false, length = 30)
    private String genre;

    @Column(name = "imdb_rating", nullable = false)
    private Float imdbRating;
}