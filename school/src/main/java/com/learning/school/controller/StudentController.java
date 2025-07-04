package com.learning.school.controller;

import com.learning.school.common.ResponseHandler;
import com.learning.school.dto.StudentDto;
import com.learning.school.dto.SuccessResponseDto;
import com.learning.school.entity.Course;
import com.learning.school.entity.Student;
import com.learning.school.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<SuccessResponseDto> create(@Valid @RequestBody StudentDto dto) {
        Student student = studentService.createStudent(dto);
        return ResponseHandler.successResponseHandler(student, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponseDto> getById(@PathVariable String id) {
        Student student = studentService.getStudent(id);
        return ResponseHandler.successResponseHandler(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<SuccessResponseDto> getAll() {
        List<Student> list = studentService.getAllStudents();
        return ResponseHandler.successResponseHandler(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto> delete(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseHandler.successResponseHandler("Deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<SuccessResponseDto> enrollInCourse(@PathVariable String studentId, @PathVariable String courseId) {
        Student updated = studentService.enrollCourse(studentId, courseId);
        return ResponseHandler.successResponseHandler(updated, HttpStatus.OK);
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<SuccessResponseDto> viewEnrolledCourses(@PathVariable String studentId) {
        List<Course> courses = studentService.getEnrolledCourses(studentId);
        return ResponseHandler.successResponseHandler(courses, HttpStatus.OK);
    }
}
