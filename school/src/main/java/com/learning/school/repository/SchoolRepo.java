package com.learning.school.repository;

import com.learning.school.entity.School;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepo extends MongoRepository<School, String> {
    School findByName(String name);
    boolean existsByNameAndAddress(String name, String address);

}
