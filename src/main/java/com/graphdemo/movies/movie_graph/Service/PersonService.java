package com.graphdemo.movies.movie_graph.Service;

import com.graphdemo.movies.movie_graph.Entity.Person;
import com.graphdemo.movies.movie_graph.Repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional
    public List<Person> createPersons(List<Person> personList){
        List<Person> output = new ArrayList<>();

        personList.forEach(person -> {
            Person existing = personRepository.findByName(person.getName());
            if(existing == null){
                Person notPresent = personRepository.save(person);
                output.add(notPresent);
            }else{
                output.add(existing);
            }
        });

        return output;
    }

}
