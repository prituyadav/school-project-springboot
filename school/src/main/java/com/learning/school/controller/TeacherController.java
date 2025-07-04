package com.learning.school.controller;

import com.learning.school.dto.SuccessResponseDto;
import com.learning.school.dto.TeacherDto;
import com.learning.school.entity.Teacher;
import com.learning.school.service.TeacherService;
import com.learning.school.common.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<SuccessResponseDto> create(@Valid @RequestBody TeacherDto dto) {
        Teacher saved = teacherService.addTeacher(dto);
        return ResponseHandler.successResponseHandler(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponseDto> getById(@PathVariable String id) {
        Teacher teacher = teacherService.getTeacher(id);
        return ResponseHandler.successResponseHandler(teacher, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<SuccessResponseDto> getAll() {
        List<Teacher> list = teacherService.getAllTeachers();
        return ResponseHandler.successResponseHandler(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDto> delete(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return ResponseHandler.successResponseHandler("Deleted successfully", HttpStatus.OK);
    }
}
