package com.entity.interfaces;

import com.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Task repository.
 */
@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
