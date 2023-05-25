package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    @Id
    private String name;

    private String usage;

    @Column(name = "person_name")
    private String personName;

    public Item() {
    }

    public Item(String name, String usage, String personName) {
        this.name = name;
        this.usage = usage;
        this.personName = personName;
    }

    public String name() {
        return name;
    }

    public String usage() {
        return usage;
    }

    public String personName() {
        return personName;
    }

    @Override
    public String toString() {
        return "Item{" +
            "name='" + name + '\'' +
            ", usage='" + usage + '\'' +
            '}';
    }
}
