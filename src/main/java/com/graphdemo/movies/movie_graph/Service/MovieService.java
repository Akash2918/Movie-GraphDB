package com.graphdemo.movies.movie_graph.Service;

import com.graphdemo.movies.movie_graph.Entity.Movie;
import com.graphdemo.movies.movie_graph.Entity.Person;
import com.graphdemo.movies.movie_graph.Repository.MovieRepository;
import com.graphdemo.movies.movie_graph.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    public MovieService(MovieRepository movieRepository, PersonRepository personRepository){
        this.movieRepository = movieRepository;
        this.personRepository = personRepository;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addActorToMovie(Long movieId, Long personId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Person actor = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        movie.getActors().add(actor);
        return movieRepository.save(movie);
    }

    public Movie addDirectorToMovie(Long movieId, Long personId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Person director = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        movie.getDirectors().add(director);
        return movieRepository.save(movie);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
