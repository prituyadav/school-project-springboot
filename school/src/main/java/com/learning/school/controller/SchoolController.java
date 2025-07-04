package com.learning.school.controller;

import com.learning.school.common.ResponseHandler;
import com.learning.school.dto.SchoolDto;
import com.learning.school.dto.SuccessResponseDto;
import com.learning.school.entity.School;
import com.learning.school.service.SchoolService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/school")
@Slf4j
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @GetMapping("/greet")
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Namaste");
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponseDto> getSchool(@PathVariable String id){
        School school = schoolService.getSchoolById(id);
        return ResponseHandler.successResponseHandler( school, HttpStatus.OK);
    }

    @Cacheable
    @PostMapping("/")
    public ResponseEntity<SuccessResponseDto> createSchool( @Valid @RequestBody SchoolDto schoolDto){
        schoolService.addSchool(schoolDto);
        return ResponseHandler.successResponseHandler("Data retrieved successfully", HttpStatus.CREATED);
    }
}
