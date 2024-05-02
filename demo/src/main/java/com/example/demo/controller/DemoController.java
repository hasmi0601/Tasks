package com.example.demo.controller;

import com.example.demo.entity.Faculty;
import com.example.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {
    /*@GetMapping(value = "/")
    public String printing(){
        return "hello";
    }
     */

    @Autowired
    private FacultyService facultyService;

    public DemoController(){}

    public DemoController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/faculty")
    public Faculty postData(@RequestBody Faculty faculty){
       return facultyService.postData(faculty);
    }

    @GetMapping("/faculty")
    public List<Faculty> getData(){
        return facultyService.getData();
    }

    @GetMapping("/facultybyid/{id}")
    public Faculty getMemberById(@PathVariable("id") Long id){
        return facultyService.getMemberById(id);
    }

    @DeleteMapping("/facultydelete/{id}")
    public String deleteFaculty(@PathVariable("id") Long id){
        facultyService.deleteFaculty(id);
        return "deleted";
    }

    @PutMapping("/update/{id}")
    public Faculty updateFaculty(@PathVariable("id") Long id, @RequestBody Faculty faculty){
        return facultyService.updateFaculty(id,faculty);
    }

}
