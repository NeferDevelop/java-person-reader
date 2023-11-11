package com.klimov.lab4.entities;

/**
 * @author s.a.klimov
 */
public class Department {
    private static int idCounter = 1;

    /**
     * The unique identifier for the department.
     */
    private final int id;

    /**
     * The name of the department.
     */
    private final String name;

    /**
     * Constructs a new Department with the specified name.
     *
     * @param name the name of the department
     */
    public Department(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    /**
     * Gets the unique identifier of the department.
     *
     * @return the department identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the department.
     *
     * @return the department name
     */
    public String getName() {
        return name;
    }
}
