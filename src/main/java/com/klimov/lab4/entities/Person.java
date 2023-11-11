package com.klimov.lab4.entities;

import com.klimov.lab4.enums.Gender;

/**
 * @author s.a.klimov
 */
public class Person {

    /**
     * The unique identifier for the person.
     */
    private final int id;

    /**
     * The name of the person.
     */
    private final String name;

    /**
     * The gender of the person.
     */
    private final Gender gender;

    /**
     * The department to which the person belongs.
     */
    private final Department department;

    /**
     * The salary of the person.
     */
    private final double salary;

    /**
     * The birth date of the person.
     */
    private final String birthDate;

    /**
     * Constructs a new Person with the specified attributes.
     *
     * @param id         the unique identifier for the person
     * @param name       the name of the person
     * @param gender     the gender of the person
     * @param department the department to which the person belongs
     * @param salary     the salary of the person
     * @param birthDate  the birth date of the person
     */
    public Person(int id, String name, Gender gender, Department department, double salary, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Gets the unique identifier of the person.
     *
     * @return the person identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the person.
     *
     * @return the person name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the gender of the person.
     *
     * @return the person gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Gets the salary of the person.
     *
     * @return the person salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person
     */
    @Override
    public String toString() {
        return id + ";" + name + ";" + gender + ";" + birthDate + ";" + department.getName() + ";" + salary;
    }
}
