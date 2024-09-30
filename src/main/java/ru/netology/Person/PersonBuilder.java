package ru.netology.Person;

public class PersonBuilder {
    protected String name;
    protected String surname;
    private int age = -1;
    private String address;


    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Person build() throws IllegalArgumentException, IllegalStateException {

        if (name != null && surname != null && age != -1 && address != null) {
            Person person = new Person(name, surname, age, address);
            return person;
        } else if (name != null && surname != null && age != -1) {
            Person person = new Person(name, surname, age);
            return person;
        } else if (name != null && surname != null) {
            Person person = new Person(name, surname);
            return person;
        } else {
            IllegalStateException e = new IllegalStateException("Missing required fields.");
            throw e;
        }
    }
}
