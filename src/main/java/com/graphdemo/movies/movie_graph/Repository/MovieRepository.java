package com.graphdemo.movies.movie_graph.Repository;

import com.graphdemo.movies.movie_graph.Entity.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    Movie findByTitle(String title);
}
