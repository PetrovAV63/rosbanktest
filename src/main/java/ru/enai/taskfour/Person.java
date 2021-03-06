package ru.enai.taskfour;

public class Person {
    private final int id;
    private final String name;
    private final String surname;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name + ", surname = " + surname;
    }
}
