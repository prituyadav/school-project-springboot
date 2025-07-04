package com.learning.school.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseDto {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String teacherId;

    @NotBlank
    private String schoolId;
}
