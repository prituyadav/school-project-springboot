package com.learning.school.repository;

import com.learning.school.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {
    boolean existsByEmail(String email);
}
