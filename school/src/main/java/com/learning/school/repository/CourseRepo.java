package com.learning.school.repository;

import com.learning.school.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepo extends MongoRepository<Course, String> {
    boolean existsByTitleAndTeacherId(String title, String teacherId);
}
