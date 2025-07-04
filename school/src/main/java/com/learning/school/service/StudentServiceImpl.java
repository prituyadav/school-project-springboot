package com.learning.school.service;

import com.learning.school.dto.StudentDto;
import com.learning.school.entity.Course;
import com.learning.school.entity.Student;
import com.learning.school.exception.CustomExceptionHandler;
import com.learning.school.repository.CourseRepo;
import com.learning.school.repository.StudentRepo;
import com.learning.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    @Override
    public Student createStudent(StudentDto dto) {
        if (studentRepo.existsByEmail(dto.getEmail())) {
            throw new CustomExceptionHandler("Student already exists", HttpStatus.CONFLICT);
        }
        Student student = Student.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .schoolId(dto.getSchoolId())
                .enrolledCourses(new ArrayList<>())
                .build();
        return studentRepo.save(student);
    }

    @Override
    public Student getStudent(String id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new CustomExceptionHandler("Student not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void deleteStudent(String id) {
        if (!studentRepo.existsById(id)) {
            throw new CustomExceptionHandler("Student not found", HttpStatus.NOT_FOUND);
        }
        studentRepo.deleteById(id);
    }

    @Override
    public Student enrollCourse(String studentId, String courseId) {
        Student student = getStudent(studentId);
        courseRepo.findById(courseId)
                .orElseThrow(() -> new CustomExceptionHandler("Course not found", HttpStatus.NOT_FOUND));

        if (!student.getEnrolledCourses().contains(courseId)) {
            student.getEnrolledCourses().add(courseId);
            studentRepo.save(student);
        }

        return student;
    }

    @Override
    public List<Course> getEnrolledCourses(String studentId) {
        Student student = getStudent(studentId);
        return courseRepo.findAllById(student.getEnrolledCourses());
    }
}
