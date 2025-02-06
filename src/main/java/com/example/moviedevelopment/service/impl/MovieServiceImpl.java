package com.example.moviedevelopment.service.impl;
import com.example.moviedevelopment.domain.entity.MovieEntity;
import com.example.moviedevelopment.domain.repository.MovieRepository;
import com.example.moviedevelopment.dto.request.MovieRequest;
import com.example.moviedevelopment.dto.response.MovieResponse;
import com.example.moviedevelopment.exceptions.*;
import com.example.moviedevelopment.mapper.MovieMapper;
import com.example.moviedevelopment.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieResponse> getAllMovies() {

        List<MovieEntity> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            throw new EmptyDatabaseException("No movies found in the database");
        }
        return movies.stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponse getMovieById(Long id) {

        if (id <= 0) {
            throw new BadRequestException("ID must be a positive number");
        }

        MovieEntity movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with ID " + id + " not found"));
        return movieMapper.toDTO(movie);
    }

    @Override
    public MovieResponse addMovie(MovieRequest dto) {

        validateMovieRequest(dto);

        if (movieRepository.existsByTitleAndDirector(dto.getTitle(), dto.getDirector())) {
            throw new DuplicateMovieException("Movie with the same title and director already exists");
        }

        MovieEntity movie = movieMapper.toEntity(dto);
        try {
            movieRepository.save(movie);
        } catch (Exception e) {
            throw new DatabaseException("Error occurred while saving the movie to the database");
        }

        return movieMapper.toDTO(movie);
    }

    @Override
    public MovieResponse updateMovie(Long id, MovieRequest dto) {
        if (id <= 0) {
            throw new BadRequestException("ID must be a positive number");
        }

        MovieEntity existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with ID " + id + " not found"));

        validateMovieRequest(dto);

        existingMovie.setTitle(dto.getTitle());
        existingMovie.setDirector(dto.getDirector());
        existingMovie.setReleaseYear(dto.getReleaseYear());
        existingMovie.setGenre(dto.getGenre());
        existingMovie.setImdbRating(dto.getImdbRating());

        try {
            movieRepository.save(existingMovie);
        } catch (Exception e) {
            throw new DatabaseException("Error occurred while updating the movie in the database");
        }

        return movieMapper.toDTO(existingMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        if (id <= 0) {
            throw new BadRequestException("ID must be a positive number");
        }

        if (!movieRepository.existsById(id)) {
            throw new EntityDeletionException("Movie with ID " + id + " cannot be deleted because it does not exist");
        }

        try {
            movieRepository.deleteById(id);
        } catch (Exception e) {
            throw new MovieAlreadyDeletedException("Movie with ID " + id + " has already been deleted");
        }
    }

    private void validateMovieRequest(MovieRequest dto) {
        if (dto.getReleaseYear() < 1888 || dto.getReleaseYear() > 2100) {
            throw new InvalidYearException("Release year must be between 1888 and 2100");
        }

        if (dto.getImdbRating() < 0 || dto.getImdbRating() > 10) {
            throw new InvalidRatingException("IMDb rating must be between 0 and 10");
        }

        if (dto.getTitle() == null || dto.getTitle().isEmpty()) {
            throw new ValidationException("Title must not be null or empty");
        }

        if (dto.getDirector() == null || dto.getDirector().isEmpty()) {
            throw new ValidationException("Director must not be null or empty");
        }

        if (dto.getGenre() == null || dto.getGenre().isEmpty()) {
            throw new ValidationException("Genre must not be null or empty");
        }
    }
}