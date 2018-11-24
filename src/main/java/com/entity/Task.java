package com.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Task.
 */
@Document(collection = "task")
public class Task {

    @Id
    private String id;
    private String description;

    /**
     * Instantiates a new Task.
     */
    public Task() {
    }

    /**
     * Instantiates a new Task.
     *
     * @param id          the task id
     * @param description the description
     */
    public Task(String id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Instantiates a new Task.
     *
     * @param description the description
     */
    public Task(String description) {
        this.description = description;
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
