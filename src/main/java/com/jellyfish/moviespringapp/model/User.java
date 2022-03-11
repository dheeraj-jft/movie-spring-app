package com.jellyfish.moviespringapp.model;

import com.jellyfish.moviespringapp.utils.UuidGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {

    @Id
    private String id = UuidGenerator.uuid();

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


}
