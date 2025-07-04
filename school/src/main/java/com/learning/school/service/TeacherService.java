package com.learning.school.service;

import com.learning.school.dto.TeacherDto;
import com.learning.school.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addTeacher(TeacherDto dto);
    Teacher getTeacher(String id);
    List<Teacher> getAllTeachers();
    void deleteTeacher(String id);
}
