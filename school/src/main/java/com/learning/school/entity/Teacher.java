package com.learning.school.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "teachers")
public class Teacher {
    @Id
    private String id;
    private String name;
    private String email;
    private String subject;
    private String schoolId;
}
