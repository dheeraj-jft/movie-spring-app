package com.jellyfish.moviespringapp.repository;

import com.jellyfish.moviespringapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    Movie findMovieByShowIdAndIsActive(String showId, Boolean isActive);
    List<Movie> findAllByIsActive(Boolean status);

}
