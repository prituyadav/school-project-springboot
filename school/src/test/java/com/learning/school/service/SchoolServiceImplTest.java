package com.learning.school.service;

import com.learning.school.entity.School;
import com.learning.school.exception.CustomExceptionHandler;
import com.learning.school.repository.SchoolRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SchoolServiceImplTest {

    @InjectMocks
    private SchoolServiceImpl schoolService;

    @Mock
    private SchoolRepo schoolRepo;

    @Test
    void findSchoolById(){
        String id = "1";
        School school = new School(id, "Model", "CBSC", "MP");

        when(schoolRepo.findById(id)).thenReturn(Optional.of(school));

        Optional<School> result = schoolRepo.findById(id);
        assertEquals("Model", result.get().getName());
        verify(schoolRepo).findById(id);

    }

    @Test
    void testGetSchoolById_whenNotFound_shouldThrowException() {
        String id = "999";
        when(schoolRepo.findById(id)).thenReturn(Optional.empty());

        assertThrows(CustomExceptionHandler.class, () -> {
            schoolService.getSchoolById(id);
        });
    }
}
