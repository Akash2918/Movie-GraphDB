package com.graphdemo.movies.movie_graph.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

// ToDo [High] : Create DTO to fix deserialization issue

@Node
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String title;

//    @JsonManagedReference("actors")
    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private Set<Person> actors = new HashSet<>();

//    @JsonManagedReference("directors")
    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private Set<Person> directors = new HashSet<>();
}
