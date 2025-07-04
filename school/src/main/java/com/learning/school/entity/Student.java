package com.learning.school.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private String schoolId;
    private List<String> enrolledCourses;  // List of course IDs
}
