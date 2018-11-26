package com.services;

import com.entity.Task;

import java.util.List;
import java.util.Optional;

/**
 * The interface Task service.
 */
public interface TaskService {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Task> findAll();

    /**
     * Insert.
     *
     * @param task the task
     */
    void insert(Task task);

    /**
     * Save.
     *
     * @param task the task
     */
    void save(Task task);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(String id);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Task> findById(String id);

    /**
     * Gets user tasks.
     *
     * @param userId the user id
     * @return the user tasks
     */
    List<Task> getUserTasks(String userId);
}
