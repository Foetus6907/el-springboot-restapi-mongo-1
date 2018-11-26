package com.controllers;

import com.entity.Task;
import com.entity.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //private UserRepository userRepository;
    //private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    /**
     * Instantiates a new User controller.
     */
    public UserController() {
    }

    /**
     * Gets all user.
     *
     * @return the all
     */
    @RequestMapping("/all")
    public List<User> getAll() {
        return this.userService.findAll();
    }

    /**
     * Create user.
     *
     * @param user the user
     */
    @PutMapping
    public void insert(@RequestBody User user) {
        this.userService.insert(user);
    }

    /**
     * Update user.
     *
     * @param user the user
     */
    @PostMapping
    public void update(@RequestBody User user) {
        this.userService.save(user);
    }

    /**
     * Delete user by id.
     *
     * @param id the user id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.userService.deleteById(id);
    }

    /**
     * Gets user by id.
     *
     * @param id the user id
     * @return the user by id
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") String id) {
        return this.userService.findById(id);
    }

    /**
     * Gets user by name.
     *
     * @param name the name
     * @return the user by name
     */
    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable("name") String name) {
        return this.userService.findUserByFirstName(name);
    }

    /**
     * Gets user by task id.
     *
     * @param id the id
     * @return the user by task id
     */
    @GetMapping("/task/{id}")
    public List<User> getUserByTaskId(@PathVariable("id") String id) {
        return this.userService.findByTaskId(id);
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

        if (this.userService.assignTaskToUser(userId, taskId)) {
        } else {
            response.sendError(422, "Enable to assign task to user. " +
                    "User and/or task does not exist in database");
        }
    }
}
