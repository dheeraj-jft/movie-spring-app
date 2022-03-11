package com.jellyfish.moviespringapp.controller;

import com.jellyfish.moviespringapp.dto.MovieDto;
import com.jellyfish.moviespringapp.model.Movie;
import com.jellyfish.moviespringapp.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping()
    public ResponseEntity<List<Movie>> getMovies() {
        log.info("------getMovies-----");
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addMovie(@RequestBody MovieDto movieDto, Model model) {
        log.info("------Add-Movies-----");
        movieService.addMovie(movieDto);
        return new ResponseEntity<>("movie added successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{showId}")
    public void deleteMovie(@PathVariable String showId) {
        log.info("---Delete Movie ---");
        movieService.deleteMovie(showId);
    }

    @PutMapping("/activate/{showId}")
    public ResponseEntity<String> activeMovie(@PathVariable String showId){
        log.info("---Activate Movie---");
        movieService.setMovieAsActive(showId);
        return new ResponseEntity<>("Movie Activate Successfully",HttpStatus.OK);
    }



    @GetMapping("/byId/{showId}")
    public ResponseEntity<Movie> getMovie(@PathVariable String showId) {
        log.info("---- Get Movie by Id---");
        return new ResponseEntity<>(movieService.getMovieById(showId), HttpStatus.OK);
    }

    @PutMapping("/{showId}")
    public ResponseEntity<String> editMovie(@RequestBody MovieDto movieDto) {
        log.info("---- Get showID -----");
        movieService.editMovie(movieDto);
        return new ResponseEntity<>("Movie updated successfully!!", HttpStatus.OK);
    }
    @GetMapping("/deactivated")
    public ResponseEntity<List<Movie>> getAllDeactivateMovies(){
        log.info("---Get all Deactived Movies---");
        return new ResponseEntity<>(movieService.getAllDeactivateMovies(),HttpStatus.OK);

    }

}
