package com.example.demo.application;

import com.example.demo.exceptions.PersonNotFound;
import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateItemService {
    private final PersonRepository personRepository;

    public CreateItemService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    void createItem(String personName, String name, String usage) {
        Person person = personRepository.findByName(personName)
            .orElseThrow(() -> new PersonNotFound(personName));

        person.addItem(name, usage);

        personRepository.save(person);
    }
}
