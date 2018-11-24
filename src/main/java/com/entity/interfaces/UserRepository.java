package com.entity.interfaces;

import com.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findUserByFirstName(String name);

    @Query(value = "{'tasks.id':?0}")
    List<User> findByTaskId (String id);
}
