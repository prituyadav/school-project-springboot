package com.learning.school.repository;

import com.learning.school.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepo extends MongoRepository<Teacher, String> {
    boolean existsByEmail(String email);
}
