package com;

import com.entity.Task;
import com.entity.User;
import com.entity.interfaces.TaskRepository;
import com.entity.interfaces.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private UserRepository userRepository;
    private TaskRepository taskRepository;

    public DbSeeder(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            // drop all Users
            this.userRepository.deleteAll();
            // drop all Task
            this.taskRepository.deleteAll();

            Task task1 = new Task("Make the EL exercise");
            Task task2 = new Task("Check Mohamed EL exercise");
            Task task3 = new Task(new ObjectId().toString(), "Test Mohamed EL exercise");

            // add tasks to the db
            List<Task> tasks = Arrays.asList(task1, task2, task3);
            this.taskRepository.saveAll(tasks);

            User mohamed = new User(
                    "Mohamed",
                    "Ghoubali",
                    Arrays.asList(task1)
            );
            User bill = new User(
                    "Bill",
                    "May",
                    Arrays.asList(task2)
            );
            User david = new User(
                    "david",
                    "Silva",
                    Arrays.asList(task3)
            );

            // add users to the db
            List<User> users = Arrays.asList(mohamed, bill, david);
            this.userRepository.saveAll(users);

        } catch (Exception e) {
            System.err.println(e.toString());
            throw new Exception(e);
        }


    }
}
