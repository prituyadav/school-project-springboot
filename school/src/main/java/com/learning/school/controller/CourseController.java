package com.learning.school.controller;

import com.learning.school.common.ResponseHandler;
import com.learning.school.dto.CourseDto;
import com.learning.school.dto.SuccessResponseDto;
import com.learning.school.entity.Course;
import com.learning.school.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<SuccessResponseDto> create(@Valid @RequestBody CourseDto dto) {
        Course saved = courseService.addCourse(dto);
        return ResponseHandler.successResponseHandler(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponseDto> getById(@PathVariable String id) {
        Course course = courseService.getCourse(id);
        return ResponseHandler.successResponseHandler(course, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<SuccessResponseDto> getAll() {
        List<Course> list = courseService.getAllCourses();
        return ResponseHandler.successResponseHandler(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto> delete(@PathVariable String id) {
        courseService.deleteCourse(id);
        return ResponseHandler.successResponseHandler("Deleted successfully", HttpStatus.OK);
    }
}
