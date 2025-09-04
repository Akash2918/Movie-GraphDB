package com.graphdemo.movies.movie_graph.Controller;

import com.graphdemo.movies.movie_graph.Entity.Movie;
import com.graphdemo.movies.movie_graph.Service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

//    @PutMapping("/{id}")
//    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
//        return movieService.updateMovie(id, movie);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteMovie(@PathVariable Long id) {
//        movieService.deleteMovie(id);
//    }

    // --- ACTOR RELATIONSHIP ---

    @PostMapping("/{movieId}/actors/{personId}")
    public Movie addActor(@PathVariable Long movieId, @PathVariable Long personId) {
        return movieService.addActorToMovie(movieId, personId);
    }

    // --- DIRECTOR RELATIONSHIP ---

    @PostMapping("/{movieId}/directors/{personId}")
    public Movie addDirector(@PathVariable Long movieId, @PathVariable Long personId) {
        return movieService.addDirectorToMovie(movieId, personId);
    }
}
