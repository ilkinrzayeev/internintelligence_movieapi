package com.example.moviedevelopment.mapper;

import com.example.moviedevelopment.domain.entity.MovieEntity;
import com.example.moviedevelopment.dto.request.MovieRequest;
import com.example.moviedevelopment.dto.response.MovieResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieEntity toEntity(MovieRequest dto);

    MovieResponse toDTO(MovieEntity movie);
}