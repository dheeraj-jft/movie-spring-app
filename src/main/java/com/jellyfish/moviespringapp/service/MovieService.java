package com.jellyfish.moviespringapp.service;

import com.jellyfish.moviespringapp.dto.MovieDto;
import com.jellyfish.moviespringapp.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    void addMovie(MovieDto movieDto);

    void deleteMovie(String showId);

    Movie getMovieById(String showId);

    void editMovie(MovieDto movieDto);

    List<Movie> getAllDeactivateMovies();

    void setMovieAsActive(String showId);
}
