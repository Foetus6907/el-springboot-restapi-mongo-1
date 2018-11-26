package com.controllers;

import com.entity.Task;
import com.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The Task controller.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * The Task service.
     */
    @Autowired
    TaskService taskService;

    /**
     * Instantiates a new Task controller.
     */
    public TaskController() {
    }

    /**
     * Get All task
     *
     * @return the all
     */
    @RequestMapping("/all")
    public List<Task> getAllTask() {
        return this.taskService.findAll();
    }

    /**
     * Create a task
     *
     * @param task the task
     */
    @PutMapping
    public void insert(@RequestBody Task task) {
        this.taskService.insert(task);
    }

    /**
     * Updating a task
     *
     * @param task the task
     */
    @PostMapping
    public void update(@RequestBody Task task) {
        this.taskService.save(task);
    }

    /**
     * Deleting a task.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.taskService.deleteById(id);
    }

    /**
     * Gets task by id.
     *
     * @param id the id
     * @return the task by id
     */
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") String id) {
        return this.taskService.findById(id);
    }

    /**
     * Retrieve all tasks from a user
     *
     * @param userId the user id
     * @return the user tasks
     */
    @GetMapping("/usertasks/{id}")
    public List<Task> getUserTasks(@PathVariable("id") String userId) {
        return this.taskService.getUserTasks(userId);
    }

}
