package com.services;

import com.entity.Task;
import com.entity.interfaces.TaskRepository;
import com.entity.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Task service.
 * Task persistence services
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Instantiates a new Task service.
     */
    public TaskServiceImpl() {
    }

    /**
     * Find all task
     *
     * @return
     */
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    /**
     * Insert a task
     *
     * @param task the task
     */
    public void insert(Task task) {
        this.taskRepository.insert(task);
    }

    /**
     * Save (update) a task
     *
     * @param task the task
     */
    public void save(Task task) {
        this.taskRepository.save(task);
    }

    /**
     * Delete a task by is id
     *
     * @param id the id
     */
    public void deleteById(String id) {
        this.taskRepository.deleteById(id);
    }

    /**
     * Find a task by is id
     *
     * @param id the id
     * @return Optional</       Task>
     */
    public Optional<Task> findById(String id) {
        return this.taskRepository.findById(id);
    }

    /**
     * Find user tasks by the user id
     *
     * @param userId the user id
     * @return List</       Task>
     */
    public List<Task> getUserTasks(String userId) {
        return this.userRepository.findById(userId).get().getTasks();
    }

}
