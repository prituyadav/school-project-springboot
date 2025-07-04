package com.learning.school.service;

import com.learning.school.dto.SchoolDto;
import com.learning.school.entity.School;

public interface SchoolService {
    School getSchoolById(String id);
    void addSchool(SchoolDto school);
}
