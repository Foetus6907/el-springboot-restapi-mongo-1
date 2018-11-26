package com.services;

import com.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Gets all user.
     *
     * @return the all
     */
    List<User> findAll();

    /**
     * Create user.
     *
     * @param user the user
     */
    void insert(User user);

    /**
     * Update user.
     *
     * @param user the user
     */
    void save(User user);

    /**
     * Delete user by id.
     *
     * @param id the user id
     */
    void deleteById(String id);

    /**
     * Gets user by id.
     *
     * @param id the user id
     * @return the user by id
     */
    Optional<User> findById(String id);

    /**
     * Gets user by name.
     *
     * @param name the name
     * @return the user by name
     */
    User findUserByFirstName(String name);

    /**
     * Gets user by task id.
     *
     * @param id the id
     * @return the user by task id
     */
    List<User> findByTaskId(String id);

    /**
     * Assign task to user.
     *
     * @param userId the user id
     * @param taskId the task id
     * @return the boolean
     */
    boolean assignTaskToUser(String userId, String taskId);
}
