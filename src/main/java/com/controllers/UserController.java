package com.controllers;

import com.entity.Task;
import com.entity.User;
import com.entity.interfaces.TaskRepository;
import com.entity.interfaces.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * The User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private TaskRepository taskRepository;

    /**
     * Instantiates a new User controller.
     *
     * @param userRepository the user repository
     * @param taskRepository the task repository
     */
    public UserController(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    /**
     * Gets all user.
     *
     * @return the all
     */
    @RequestMapping("/all")
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    /**
     * Create user.
     *
     * @param user the user
     */
    @PutMapping
    public void insert(@RequestBody User user) {
        this.userRepository.insert(user);
    }

    /**
     * Update user.
     *
     * @param user the user
     */
    @PostMapping
    public void update(@RequestBody User user) {
        this.userRepository.save(user);
    }

    /**
     * Delete user by id.
     *
     * @param id the user id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.userRepository.deleteById(id);
    }

    /**
     * Gets user by id.
     *
     * @param id the user id
     * @return the user by id
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") String id) {
        return this.userRepository.findById(id);
    }

    /**
     * Gets user by name.
     *
     * @param name the name
     * @return the user by name
     */
    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable("name") String name) {
        return this.userRepository.findUserByFirstName(name);
    }

    /**
     * Gets user by task id.
     *
     * @param id the id
     * @return the user by task id
     */
    @GetMapping("/task/{id}")
    public List<User> getUserByTaskId(@PathVariable("id") String id) {
        return this.userRepository.findByTaskId(id);
    }

    /**
     * Assign task to user.
     *
     * @param userId   the user id
     * @param taskId   the task id
     * @param response the response
     * @throws IOException the io exception
     */
    @PostMapping("assigntask/{userid}/{taskid}")
    public void assignTaskToUser(@PathVariable("userid") String userId, @PathVariable("taskid") String taskId,
                                 HttpServletResponse response) throws IOException {
        Optional<Task> taskToAssign = this.taskRepository.findById(taskId);
        Optional<User> userToAssignTask = this.userRepository.findById(userId);

        if (taskToAssign.isPresent() && userToAssignTask.isPresent()) {
            User user = userToAssignTask.get();
            Task task = taskToAssign.get();
            List<Task> userTask = user.getTasks();
            userTask.add(task);
            user.setTasks(userTask);
            this.userRepository.save(user);
        } else {
            response.sendError(422, "Enable to assign task to user. " +
                    "User and/or task does not exist in database");
        }
    }
}
