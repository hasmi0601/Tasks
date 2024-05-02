package com.example.demo.service;

import com.example.demo.entity.Faculty;
import com.example.demo.repository.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyRepo frepo;

    public FacultyServiceImpl(FacultyRepo frepo){
        this.frepo = frepo;
    }

    @Override
    public Faculty postData(Faculty faculty) {
        return frepo.save(faculty);
    }

    @Override
    public List<Faculty> getData() {
        return frepo.findAll();
    }

    @Override
    public Faculty getMemberById(Long id) {
        return frepo.findById(id).get();
    }

    @Override
    public void deleteFaculty(Long id) {
        frepo.deleteById(id);
        //return "deleted";
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty f=frepo.findById(id).get();
        if(Objects.nonNull(faculty.getDept()) && !"".equalsIgnoreCase(faculty.getDept())){
            f.setDept(faculty.getDept());
        }
        if(Objects.nonNull(faculty.getDesignation()) && !"".equalsIgnoreCase(faculty.getDesignation())){
            f.setDesignation(faculty.getDesignation());
        }
        if(Objects.nonNull(faculty.getName()) && !"".equalsIgnoreCase(faculty.getName())){
            f.setName(faculty.getName());
        }
        if(Objects.nonNull(faculty.getMobileno())){
            f.setMobileno(faculty.getMobileno());
        }
        if(Objects.nonNull(faculty.getSubject()) && !"".equalsIgnoreCase((faculty.getSubject()))){
            f.setSubject(faculty.getSubject());
        }
        return frepo.save(f);
    }

}
