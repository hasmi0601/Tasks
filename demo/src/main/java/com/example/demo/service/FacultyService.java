package com.example.demo.service;


import com.example.demo.entity.Faculty;

import java.util.List;

public interface FacultyService {

    public Faculty postData(Faculty faculty);

    public List<Faculty> getData();

    public Faculty getMemberById(Long id);

    public void deleteFaculty(Long id);

    public Faculty updateFaculty(Long id, Faculty faculty);
}
