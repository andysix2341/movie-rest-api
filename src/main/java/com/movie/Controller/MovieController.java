package com.movie.Controller;

import java.util.List;
import java.util.UUID;

import com.movie.Dto.MovieRequestDto;
import com.movie.Exception.ResourceNotFoundException;
import com.movie.Model.Album;
import com.movie.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    
    private final MovieService movieService;
    
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<String> getMovieById(@PathVariable("movieId") UUID movieId) {
        Album selectedMovie = movieService.getMovieById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no movie with this id" + movieId));
        return ResponseEntity.status(200).body("Id of the Movie is, " + selectedMovie.getMovie_id() + "Name of the Movie is " + selectedMovie.getMovieName() + ", Movie director is " + selectedMovie.getDirector());
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody MovieRequestDto movieDto) {
        movieService.addMovie(movieDto);
        return ResponseEntity.status(201).body("Movie has added into database");
    }

    @GetMapping
    public List<Album> getAllMovieAlbum() {
        return movieService.getAllMovie();
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<String> updateMovie(@PathVariable("movieId") UUID movieId, @RequestBody MovieRequestDto movieDto) {
        movieService.updateMovieById(movieId, movieDto);
        return ResponseEntity.status(201).body("The movie is updated");

    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable("movieId") UUID movieId) {
        movieService.deletMovieById(movieId);
        return ResponseEntity.status(200)
            .body("Movie has been deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllMovie() {
        movieService.deleteAllMovie();
        return ResponseEntity.status(200)
            .body("All Movie has been deleted");
    }

}
