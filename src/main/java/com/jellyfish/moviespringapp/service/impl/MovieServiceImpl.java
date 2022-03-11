package com.jellyfish.moviespringapp.service.impl;

import com.jellyfish.moviespringapp.dto.MovieDto;
import com.jellyfish.moviespringapp.exception.MovieNotFoundException;
import com.jellyfish.moviespringapp.model.Movie;
import com.jellyfish.moviespringapp.repository.MovieRepository;
import com.jellyfish.moviespringapp.service.MovieService;
import com.jellyfish.moviespringapp.utils.DateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAllByIsActive(true);
    }

    @Override
    public void addMovie(MovieDto movieDto)
    {
        Movie movie = new Movie();
        movie.setDateAdded(DateGenerator.getDateInString());
        movie.setType(movieDto.getType());
        movie.setTitle(movieDto.getTitle());
        movie.setRating(movieDto.getRating());
        movie.setDuration(movieDto.getDuration());
        movie.setDirector(movieDto.getDirector());
        movie.setDescription(movieDto.getDescription());
        movie.setCast(movieDto.getCast());
        movie.setCountry(movieDto.getCountry());
        movie.setReleaseYear(movieDto.getReleaseYear());
        movie.setListedIn(movieDto.getListedIn());
        movie.setIsActive(true);
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(String showId) {
        Movie movie = movieRepository.getById(showId);
        movie.setIsActive(false);
        movie.setDateAdded(DateGenerator.getDateInString());
        movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(String showId) {
        return movieRepository.findMovieByShowIdAndIsActive(showId,Boolean.TRUE);
    }

    @Override
    public void editMovie(MovieDto movieDto) {
        Movie movie = movieRepository.findMovieByShowIdAndIsActive(movieDto.getShowId(),Boolean.TRUE);
        if (movie != null) {
            movie.setCast(movieDto.getCast());
            movie.setCountry(movieDto.getCountry());
            movie.setDescription(movieDto.getDescription());
            movie.setDateAdded(DateGenerator.getDateInString());
            movie.setDirector(movieDto.getDirector());
            movie.setDuration(movieDto.getDuration());
            movie.setListedIn(movieDto.getListedIn());
            movie.setRating(movieDto.getRating());
            movie.setReleaseYear(movieDto.getReleaseYear());
            movie.setTitle(movieDto.getTitle());
            movie.setType(movieDto.getType());
            movieRepository.save(movie);
        }

    }

    @Override
    public List<Movie> getAllDeactivateMovies() {
        return movieRepository.findAllByIsActive(false);
    }

    @Override
    public void setMovieAsActive(String showId) {
        Movie movie = movieRepository.findMovieByShowIdAndIsActive(showId,false);
        if(movie!= null) {
            movie.setIsActive(true);
            movie.setDateAdded(DateGenerator.getDateInString());
            movieRepository.save(movie);
        }else{
            throw new MovieNotFoundException("Movie not Found with showId : "+showId);
        }

    }
}
