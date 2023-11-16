package com.example.demo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "people")
public class Person {
    @Id
    private String name;

    @Embedded
    private Age age;

    @Embedded
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_name")
    @OrderBy("name")
    private List<Item> items = new ArrayList<>();

    public Person() {
    }

    public Person(String name, Age age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void addItem(String name, String usage) {
        Item item = new Item(name, usage, this.name);

        items.add(item);
    }

    public void removeItem(String name) {
        Optional<Item> item = items.stream()
            .filter(i -> i.name().equals(name))
            .findFirst();

        if (item.isEmpty()) {
            return;
        }

        items.remove(item.get());
    }

    public List<Item> items() {
        return new ArrayList<>(items);
    }

    public String name() {
        return name;
    }

    public Age age() {
        return age;
    }

    public Gender gender() {
        return gender;
    }

    public void changeAge(Age age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", gender=" + gender +
            ", items=" + items +
            '}';
    }
}
