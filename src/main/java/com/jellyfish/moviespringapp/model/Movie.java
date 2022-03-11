package com.jellyfish.moviespringapp.model;


import com.jellyfish.moviespringapp.utils.DateGenerator;
import com.jellyfish.moviespringapp.utils.UuidGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
public class Movie {

    @Id
    private String showId = UuidGenerator.uuid();

    @Column
    private String type;

    @Column(nullable = false)
    private String title;

    @Column
    private String director;

    @Column
    private String cast;

    @Column
    private String country;

    @Column
    private String dateAdded = DateGenerator.getDateInString();

    @Column
    private String releaseYear;

    @Column
    private String rating;

    @Column
    private String duration;

    @Column
    private String listedIn;

    @Column
    private String description;

    @Column(nullable = false)
    private Boolean isActive;



}
