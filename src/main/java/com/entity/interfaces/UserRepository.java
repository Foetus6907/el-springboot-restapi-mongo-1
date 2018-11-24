package com.entity.interfaces;

import com.entity.Task;
import com.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Find user by first name user.
     *
     * @param name the user name
     * @return the user
     */
    User findUserByFirstName(String name);

    /**
     * Find by task id list.
     *
     * @param id the user id
     * @return the list
     */
    @Query(value = "{'tasks.id':?0}")
    List<User> findByTaskId(String id);
}
