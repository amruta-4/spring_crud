package com.example.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.springproject.dto.PatientDto;

@Component
public interface PatientRepository extends JpaRepository<PatientDto, Integer>{

}
