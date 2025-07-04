package com.learning.school.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDto {
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String schoolId;
}