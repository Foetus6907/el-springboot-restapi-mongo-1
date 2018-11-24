package com.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User.
 */
@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private List<Task> tasks;

    /**
     * Instantiates a new User.
     */
    protected User() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param tasks     the tasks
     */
    public User(String firstName, String lastName, List<Task> tasks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tasks = tasks;
    }

    /**
     * Instantiates a new User.
     *
     * @param id        the id
     * @param firstName the first name
     * @param lastName  the last name
     * @param tasks     the tasks
     */
    public User(String id, String firstName, String lastName, List<Task> tasks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tasks = tasks;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets tasks.
     *
     * @return the tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Sets tasks.
     *
     * @param tasks the tasks
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
