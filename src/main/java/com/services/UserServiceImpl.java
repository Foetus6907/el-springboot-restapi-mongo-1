package com.services;

import com.entity.Task;
import com.entity.User;
import com.entity.interfaces.TaskRepository;
import com.entity.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type User service.
 * User persistence service
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Instantiates a new User service.
     */
    public UserServiceImpl() {
    }

    /**
     * Gets all user.
     *
     * @return the all
     */
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    /**
     * Create user.
     *
     * @param user the user
     */
    public void insert(User user) {
        this.userRepository.insert(user);
    }

    /**
     * Update user.
     *
     * @param user the user
     */
    public void save(User user) {
        this.userRepository.save(user);
    }

    /**
     * Delete user by id.
     *
     * @param id the user id
     */
    public void deleteById(String id) {
        this.userRepository.deleteById(id);
    }

    /**
     * Gets user by id.
     *
     * @param id the user id
     * @return the user by id
     */
    public Optional<User> findById(String id) {
        return this.userRepository.findById(id);
    }

    /**
     * Gets user by name.
     *
     * @param name the name
     * @return the user by name
     */
    public User findUserByFirstName(String name) {
        return this.userRepository.findUserByFirstName(name);
    }

    /**
     * Gets user by task id.
     *
     * @param id the id
     * @return the user by task id
     */
    public List<User> findByTaskId(String id) {
        return this.userRepository.findByTaskId(id);
    }

    /**
     * Assign task to user.
     *
     * @param userId the user id
     * @param taskId the task id
     * @return the boolean
     */
    public boolean assignTaskToUser(String userId, String taskId) {
        Optional<Task> taskToAssign = this.taskRepository.findById(taskId);
        Optional<User> userToAssignTask = this.userRepository.findById(userId);

        if (taskToAssign.isPresent() && userToAssignTask.isPresent()) {
            User user = userToAssignTask.get();
            Task task = taskToAssign.get();
            List<Task> userTask = user.getTasks();
            userTask.add(task);
            user.setTasks(userTask);
            this.userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
