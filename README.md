# internintelligence_movieapi


![Screenshot 2025-01-24 233519](https://github.com/user-attachments/assets/e2fcceca-0030-48e3-a272-c2257a2c6130)


# InternIntelligence_PortfoliAPI
# Movie API Development

## Overview
This project is a RESTful API designed for managing a movie database. The API provides functionality for performing CRUD (Create, Read, Update, Delete) operations on movie records, making it a versatile solution for applications that require organized movie data management.

## Features
- **CRUD Operations**:
  - **Create**: Add new movie records to the database.
  - **Read**: Retrieve detailed movie information, including title, director, release year, genre, and IMDb rating.
  - **Update**: Modify existing movie details.
  - **Delete**: Remove movie records from the database.
- **Interactive Documentation**:
  - Integrated Swagger documentation for easy testing and seamless integration.

## Data Model
The API supports movie details including:
- **Title**: The name of the movie.
- **Director**: The person who directed the movie.
- **Release Year**: The year the movie was released.
- **Genre**: The category of the movie (e.g., Action, Drama, Comedy).
- **IMDb Rating**: The movie's rating on IMDb.

## API Endpoints
The following endpoints are included:
1. **GET /movies**: Retrieve a list of all movies.
2. **GET /movies/{id}**: Retrieve details of a specific movie.
3. **POST /movies**: Add a new movie to the database.
4. **PUT /movies/{id}**: Update an existing movie's information.
5. **DELETE /movies/{id}**: Delete a movie from the database.
