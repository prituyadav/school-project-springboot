package com.learning.school.service;

import com.learning.school.dto.CourseDto;
import com.learning.school.entity.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(CourseDto dto);
    Course getCourse(String id);
    List<Course> getAllCourses();
    void deleteCourse(String id);
}
