package com.example.springboottask.repository;

import com.example.springboottask.entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepo extends JpaRepository<Details,Long> {
}
