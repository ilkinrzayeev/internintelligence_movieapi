package com.example.moviedevelopment.service;

import com.example.moviedevelopment.dto.request.MovieRequest;
import com.example.moviedevelopment.dto.response.MovieResponse;

import java.util.List;

public interface MovieService {
    List<MovieResponse> getAllMovies();

    MovieResponse getMovieById(Long id);

    MovieResponse addMovie(MovieRequest dto);

    MovieResponse updateMovie(Long id, MovieRequest dto);

    void deleteMovie(Long id);
}