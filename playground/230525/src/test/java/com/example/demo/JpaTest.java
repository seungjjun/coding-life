package com.example.demo;

import com.example.demo.models.Age;
import com.example.demo.models.Gender;
import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JpaTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    @Transactional
    void findAll() {
        List<Person> people = personRepository.findAll();

        assertThat(people).hasSize(2);
    }

    @Test
    @Transactional
    void createAndDelete() {
        Person person = new Person("Mr.Big", new Age(35), Gender.male());

        personRepository.save(person);

        Optional<Person> found = personRepository.findByName("Mr.Big");

        personRepository.delete(found.get());
    }
}
