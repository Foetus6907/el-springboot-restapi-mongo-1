package com;

import com.entity.Task;
import com.entity.User;
import com.entity.interfaces.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sun.security.util.ObjectIdentifier;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private UserRepository userRepository;

    public DbSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User mohamed = new User(
                "Mohamed",
                "Ghoubali",
                Arrays.asList(new Task(new ObjectId().toString(),"Make the EL exercise"))
        );
        User bill = new User(
                "Bill",
                "May",
                Arrays.asList(new Task(new ObjectId().toString(),"Check Mohamed EL exercise"))
        );
        User david = new User(
                "david",
                "Silva",
                Arrays.asList(new Task(new ObjectId().toString(),"Test Mohamed EL exercise"))

        );

        // drop all Users
        this.userRepository.deleteAll();

        // add users to the db
        List<User> users = Arrays.asList(mohamed,bill,david);
        this.userRepository.saveAll(users);
    }
}
