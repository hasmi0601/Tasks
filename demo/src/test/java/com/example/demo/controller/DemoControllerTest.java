package com.example.demo.controller;

import com.example.demo.entity.Faculty;
import com.example.demo.repository.FacultyRepo;
import com.example.demo.service.FacultyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DemoControllerTest {
    @Autowired
    private FacultyRepo facultyRepo;
    private Faculty expectedFaculty = new Faculty(1L, 10322L, "Mahesh", "Assistant Professor", "DS", "IT", "9890734234");
    private Faculty expectedFaculty2= new Faculty(2L,10321L,"Ramesh","Professor","Physics","CSE","9823145456");

    @Test
    void shouldSaveData(){
        Faculty faculty=facultyRepo.save(expectedFaculty);
        Assertions.assertThat(faculty).isNotNull();
    }

    /*private FacultyService facultyService = mock(FacultyService.class);
    private FacultyRepo facultyRepo=mock(FacultyRepo.class);
    private DemoController demoController = new DemoController(facultyService);
    private Faculty expectedFaculty = new Faculty(1, 10322, "Mahesh", "Assistant Professor", "DS", "IT", "9890734234");
    private Faculty expectedFaculty2= new Faculty(2,10321,"Ramesh","Professor","Physics","CSE","9823145456");

    @Test
    void shouldPostFacultyData() {
        demoController.postData((expectedFaculty));
        verify(facultyService,times(1)).postData(expectedFaculty);

    }

    @Test
    void shouldReturnRequiredFacultyData() {
        when(facultyService.postData(expectedFaculty)).thenReturn(expectedFaculty);
        var actualFaculty = demoController.postData(expectedFaculty);
        assertEquals(expectedFaculty, actualFaculty);
    }


    @Test
    void fetchAllData(){
        when(facultyService.getData()).thenReturn(List.of(expectedFaculty,expectedFaculty2));
        var facultyList=demoController.getData();
        assertEquals(facultyList,List.of(expectedFaculty,expectedFaculty2));
    }

    @Test
    void shouldGetFacultyById(){
        when(facultyService.getMemberById(expectedFaculty.getId())).thenReturn(expectedFaculty);
        var faculty =demoController.getMemberById(expectedFaculty.getId());
        assertEquals(faculty,expectedFaculty);
    }

    @Test
    void checkDeleted(){
        when(facultyService.deleteFaculty(expectedFaculty.getId())).thenReturn("deleted");
        String s=demoController.deleteFaculty(expectedFaculty.getId());
        assertEquals(s,"deleted");
    }

     */

    


}