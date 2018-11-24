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

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private TaskRepository taskRepository;

    public UserController(UserRepository userRepository, TaskRepository taskRepository){
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @RequestMapping("/all")
	public List<User> getAll(){
		return this.userRepository.findAll();
	}

	@PutMapping
    public void insert(@RequestBody User user){
        this.userRepository.insert(user);
    }

    @PostMapping
    public void update(@RequestBody User user){
        this.userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.userRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") String id){
        return this.userRepository.findById(id);
    }

    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable("name") String name){
        return this.userRepository.findUserByFirstName(name);
    }

    @GetMapping("/task/{description}")
    public List<User> getUserByTaskId(@PathVariable("description") String description){
        return this.userRepository.findByTaskId(description);
    }

    //  Assign a task to a user
    @PostMapping("assigntask/{userid}/{taskid}")
    public void assignTaskToUser(@PathVariable("userid") String userId, @PathVariable("taskid") String taskId,
                                 HttpServletResponse response) throws IOException {
        Optional<Task> taskToAssign = this.taskRepository.findById(taskId);
        Optional<User> userToAssignTask = this.userRepository.findById(userId);

        if (taskToAssign.isPresent() && userToAssignTask.isPresent())
        {
            User user = userToAssignTask.get();
            Task task = taskToAssign.get();
            List<Task> userTask = user.getTasks();
            userTask.add(task);
            user.setTasks(userTask);
            this.userRepository.save(user);
        } else {
            response.sendError(422,"Enable to assign task to user. " +
                                                "User and/or task does not exist in database");
        }
    }
}
