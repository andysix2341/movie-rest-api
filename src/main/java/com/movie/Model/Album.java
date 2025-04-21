package com.movie.Model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "album")
public class Album {
    
    @Id
    @GeneratedValue(generator = "movie-generator")
    @GenericGenerator(name = "movie-generator",
        strategy = "com.movie.Util.CustomUUIDGenerator"
    )
    private UUID movie_id; 

    @Column(name = "movie_name", length = 250, nullable = false)
    private String movieName;
    
    @Column(name = "director", length = 150, nullable = false)
    private String director;

    public Album(String movieName, String director) {
        this.setMovieName(movieName);
        this.setDirector(director);
    }
}
