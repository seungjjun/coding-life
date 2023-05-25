package com.example.demo.application;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CreateItemServiceTest {
    private CreateItemService createItemService;

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        createItemService = new CreateItemService(personRepository);
    }

    @Test
    void createItem() {
        createItemService.createItem("Mr.Big", "A", "...");

        Person person = personRepository.findByName("Mr.Big").get();

        assertThat(person.items()).hasSize(1);
    }
}