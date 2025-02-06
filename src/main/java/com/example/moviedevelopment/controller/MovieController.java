package com.example.moviedevelopment.controller;

import com.example.moviedevelopment.dto.request.MovieRequest;
import com.example.moviedevelopment.dto.response.MovieResponse;
import com.example.moviedevelopment.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<MovieResponse> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {
        MovieResponse movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(@RequestBody @Valid MovieRequest movieRequest) {
        MovieResponse movieResponse = movieService.addMovie(movieRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @RequestBody @Valid MovieRequest movieRequest) {
        MovieResponse updatedMovie = movieService.updateMovie(id, movieRequest);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}