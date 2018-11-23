package com;

import com.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        User mohamed = new User("Mohamed","Ghoubali");
        User david
    }
}
