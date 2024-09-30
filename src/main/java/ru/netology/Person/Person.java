package ru.netology.Person;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    private int age = -1;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        if (age >= 0) {
            this.age = age;
        } else {
            IllegalArgumentException e = new IllegalArgumentException();
            throw e;
        }
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        if (age >= 0) {
            this.age = age;
        } else {
            IllegalArgumentException e = new IllegalArgumentException();
            throw e;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        if (age != -1) {
            age += 1;
        } else {
            IllegalArgumentException e = new IllegalArgumentException("Invalid age. \n");
            throw e;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder()
                .setSurname(surname);
        return builder;
    }

    @Override
    public String toString() {
        if (age != -1 && address != null) {
            return String.format("%s %s, age %d, address %s", name, surname, age, address);
        } else if (age == -1 && address != null) {
            return  String.format("%s %s, address %s", name, surname, address);
        } else return String.format("%s %s", name, surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

}
