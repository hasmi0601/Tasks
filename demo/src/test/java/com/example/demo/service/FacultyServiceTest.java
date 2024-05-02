package com.example.demo.service;

import com.example.demo.controller.DemoController;
import com.example.demo.entity.Faculty;
import com.example.demo.repository.FacultyRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FacultyServiceTest {


    private FacultyRepo facultyRepo=mock(FacultyRepo.class);

    //private FacultyService facultyService=mock(FacultyService.class);

    FacultyService facultyService = new FacultyServiceImpl(facultyRepo);
    @InjectMocks
    private DemoController demoController = new DemoController(facultyService);

    //private DemoController demoController=new DemoController();
    private Faculty expectedFaculty = new Faculty(1L, null, "Mahesh", "Assistant Professor", "DS", "IT", "9890734234");
    private Faculty expectedFaculty2= new Faculty(2L,10321L,"Ramesh","Professor","Physics","CSE","9823145456");

    private Faculty expectedFaculty3= new Faculty(null,null,null,null,null,null,null);

    @Test
    void shouldSaveData(){
        when(facultyRepo.save(expectedFaculty)).thenReturn(expectedFaculty);
        Faculty savedFaculty=demoController.postData(expectedFaculty);
        assertEquals(savedFaculty,expectedFaculty);
        Assertions.assertThat(savedFaculty).isNotNull();
    }
    @Test
    void ifAllFieldsAreNull(){
        when(facultyRepo.save(expectedFaculty3)).thenReturn(expectedFaculty3);
        Faculty savedFaculty=demoController.postData(expectedFaculty3);
        Assertions.assertThat(savedFaculty).hasAllNullFieldsOrProperties();
        //assertFalse( savedFaculty.getName()!="" && savedFaculty.getId()!=0 && savedFaculty.getFaculty_id()!=0
        //&& savedFaculty.getDept()!="" && savedFaculty.getDesignation()!=""
        //&& savedFaculty.getSubject()!="" && savedFaculty.getMobileno()!="");
    }

    @Test
    void ifNoFieldsAreNull(){

    }

    @Test
    void ifAnyFieldIsnull(){
        when(facultyRepo.save(expectedFaculty)).thenReturn(expectedFaculty);
        Faculty faculty=demoController.postData(expectedFaculty);
        assertFalse(faculty.getName()!=null && faculty.getId()!=null && faculty.getFaculty_id()!=null
        && faculty.getDept()!=null && faculty.getDesignation()!=null && faculty.getSubject()!=null &&
                faculty.getMobileno()!=null);
    }


    @Test
    void saveDataInvocation(){
        //when(facultyRepo.save(expectedFaculty)).thenReturn(expectedFaculty);
        Faculty savedFaculty=demoController.postData(expectedFaculty);
        verify(facultyRepo).save(expectedFaculty);
    }

    @Test
    void shouldFetchData(){
        when(facultyRepo.findAll()).thenReturn(List.of(expectedFaculty,expectedFaculty2));
        List<Faculty> l =demoController.getData();
        assertEquals(l,List.of(expectedFaculty,expectedFaculty2));
        Assertions.assertThat(l).hasSize(2);
    }
    @Test
    void IfNoDataPresentIsNull(){
        when(facultyRepo.findAll()).thenReturn(List.of());
        assertTrue(demoController.getData().isEmpty());
    }

    @Test
    void shouldFetchDataById(){
        when(facultyRepo.findById(expectedFaculty.getId())).thenReturn(Optional.of(expectedFaculty));
        Faculty actualFaculty=demoController.getMemberById(expectedFaculty.getId());
        assertEquals(actualFaculty,expectedFaculty);
    }

    @Test
    void ifIdNotPresent() {
        when(facultyRepo.findById(3L)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> demoController.getMemberById(3L));
    }

    @Test
    void shouldDeleteById(){
        Mockito.doNothing().when(facultyRepo).deleteById(expectedFaculty.getId());
        demoController.deleteFaculty(expectedFaculty.getId());
        verify(facultyRepo,times(1)).deleteById(expectedFaculty.getId());
    }

    @Test
    void shouldUpdateData(){
        when(facultyRepo.findById(1L)).thenReturn(Optional.of(expectedFaculty));
        Faculty faculty=facultyRepo.findById(expectedFaculty.getId()).get();
        faculty.setDesignation("HOD");
        //expectedFaculty.setSubject("DS");
        when(facultyRepo.save(expectedFaculty)).thenReturn(faculty);
        Faculty actualFaculty=demoController.updateFaculty(expectedFaculty.getId(),expectedFaculty);
        assertEquals(actualFaculty,faculty);
    }

}