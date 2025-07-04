package com.learning.school.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolDto {
    @NotBlank(message="Name is required")
    @Min(2)
    String name;

    @NotBlank(message = "Address is required")
    @Min(10)
    String address;

    @Min(2)
    @NotBlank(message = "Board is required")
    String board;
}
