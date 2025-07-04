package com.learning.school.service;

import com.learning.school.dto.StudentDto;
import com.learning.school.entity.Course;
import com.learning.school.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto dto);
    Student getStudent(String id);
    List<Student> getAllStudents();
    void deleteStudent(String id);

    Student enrollCourse(String studentId, String courseId);
    List<Course> getEnrolledCourses(String studentId);
}
