package com.learning.school.service;

import com.learning.school.dto.SchoolDto;
import com.learning.school.entity.School;
import com.learning.school.exception.CustomExceptionHandler;
import com.learning.school.repository.SchoolRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.learning.school.common.ErrorMessageConstant.SCHOOL_NOT_FOUND;

@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService{

    private final SchoolRepo schoolRepo;

    @Autowired
    public SchoolServiceImpl(SchoolRepo schoolRepo){
        this.schoolRepo = schoolRepo;
    }

    @Cacheable(value = "school", key= "#id")
    @Override
    public School getSchoolById(String id) {
        Optional<School> school =  schoolRepo.findById(String.valueOf(id));
        if(school.isEmpty()){
            throw new CustomExceptionHandler(SCHOOL_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return school.get();

    }

    @CachePut(value = "school", key = "#result.id")
    @Override
    public void addSchool(SchoolDto school) {
        try{
            if(schoolRepo.existsByNameAndAddress(school.getName(), school.getAddress())){
                throw new CustomExceptionHandler("School already exist", HttpStatus.CONFLICT);
            }
            School schoolObj = School.builder().name(school.getName()).address(school.getAddress()).board(school.getBoard()).build();
            schoolRepo.save(schoolObj);
        }catch (Exception ex){
            log.info("SchoolServiceImpl::addSchool", ex);
            throw new CustomExceptionHandler(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
