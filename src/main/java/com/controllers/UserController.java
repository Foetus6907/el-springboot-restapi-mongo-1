package com.controllers;

import com.entity.User;
import com.entity.interfaces.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
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

    @GetMapping("{id}")
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
}
