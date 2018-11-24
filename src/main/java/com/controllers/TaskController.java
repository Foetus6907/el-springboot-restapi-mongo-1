package com.controllers;

import com.entity.Task;
import com.entity.interfaces.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get All task
    @RequestMapping("/all")
    public List<Task> getAll(){
        return this.taskRepository.findAll();
    }

    // Create a task
    @PutMapping
    public void insert(@RequestBody Task task){
        this.taskRepository.insert(task);
    }

    // Updating a task
    @PostMapping
    public void update(@RequestBody Task task){
        this.taskRepository.save(task);
    }

    // Deleting a task.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.taskRepository.deleteById(id);
    }

    // Get a task by ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") String id){
        return this.taskRepository.findById(id);
    }

    // Retrieving all tasks from a user
    @GetMapping("/usertasks/{id}")
    public List<Task> getUserTasks(@PathVariable("id") String userId){
        return this.taskRepository.findAll();
    }






}
