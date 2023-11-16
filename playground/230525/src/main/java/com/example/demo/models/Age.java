package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Age {
    @Column(name = "age")
    private int value;

    public Age() {
    }

    public Age(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return "Age{" +
            "value=" + value +
            '}';
    }
}
