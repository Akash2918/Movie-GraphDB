package com.graphdemo.movies.movie_graph.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String name;

    @JsonBackReference("actors")
    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.OUTGOING)
    private Set<Movie> actedIn = new HashSet<>();

    @JsonBackReference("directors")
    @Relationship(type = "DIRECTED", direction = Relationship.Direction.OUTGOING)
    private Set<Movie> directedMovies = new HashSet<>();
}
