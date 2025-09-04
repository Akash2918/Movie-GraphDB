package com.graphdemo.movies.movie_graph.Repository;

import com.graphdemo.movies.movie_graph.Entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {
    Person findByName(String name);
}
