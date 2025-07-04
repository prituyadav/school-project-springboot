package com.learning.school.service;

import com.learning.school.dto.TeacherDto;
import com.learning.school.entity.Teacher;
import com.learning.school.exception.CustomExceptionHandler;
import com.learning.school.repository.TeacherRepo;
import com.learning.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;

    @Override
    public Teacher addTeacher(TeacherDto dto) {
        if (teacherRepo.existsByEmail(dto.getEmail())) {
            throw new CustomExceptionHandler("Teacher with this email already exists", HttpStatus.CONFLICT);
        }
        Teacher teacher = Teacher.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .subject(dto.getSubject())
                .schoolId(dto.getSchoolId())
                .build();
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher getTeacher(String id) {
        return teacherRepo.findById(id)
                .orElseThrow(() -> new CustomExceptionHandler("Teacher not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public void deleteTeacher(String id) {
        if (!teacherRepo.existsById(id)) {
            throw new CustomExceptionHandler("Teacher not found", HttpStatus.NOT_FOUND);
        }
        teacherRepo.deleteById(id);
    }
}
