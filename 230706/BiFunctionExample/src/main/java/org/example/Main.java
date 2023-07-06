package org.example;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, String, String> biFunction = (x, y) -> x + y;

        String biFunctionResult = biFunction.apply("Hello", " World!");
        System.out.println(biFunctionResult);

        BiFunction<Person, Person, String> personBiFunction = (person1, person2) -> {
            return person1.getAge() > person2.getAge() ? person1.getName() : person2.getName();
        };

        Person jun = new Person("Jun", 25);
        Person john = new Person("John", 21);

        String elderPerson = personBiFunction.apply(jun, john);

        System.out.println(elderPerson);
    }
}
