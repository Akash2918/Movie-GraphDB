package com.graphdemo.movies.movie_graph.Service;

import com.graphdemo.movies.movie_graph.Entity.Person;
import com.graphdemo.movies.movie_graph.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).orElse(null);
    }

}
