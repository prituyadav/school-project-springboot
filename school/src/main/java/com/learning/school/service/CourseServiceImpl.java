package com.learning.school.service;

import com.learning.school.dto.CourseDto;
import com.learning.school.entity.Course;
import com.learning.school.exception.CustomExceptionHandler;
import com.learning.school.repository.CourseRepo;
import com.learning.school.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public Course addCourse(CourseDto dto) {
        if (courseRepo.existsByTitleAndTeacherId(dto.getTitle(), dto.getTeacherId())) {
            throw new CustomExceptionHandler("Course already exists for this teacher", HttpStatus.CONFLICT);
        }

        Course course = Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .teacherId(dto.getTeacherId())
                .schoolId(dto.getSchoolId())
                .build();

        return courseRepo.save(course);
    }

    @Override
    public Course getCourse(String id) {
        return courseRepo.findById(id)
                .orElseThrow(() -> new CustomExceptionHandler("Course not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public void deleteCourse(String id) {
        if (!courseRepo.existsById(id)) {
            throw new CustomExceptionHandler("Course not found", HttpStatus.NOT_FOUND);
        }
        courseRepo.deleteById(id);
    }
}
