package com.jellyfish.moviespringapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private String showId;

    private String type;

    private String title;

    private String director;

    private String cast;

    private String country;

    private String releaseYear;

    private String rating;

    private String duration;

    private String listedIn;

    private String description;

    private Boolean isActive;


}
