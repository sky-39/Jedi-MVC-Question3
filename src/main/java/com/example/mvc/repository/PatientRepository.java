package com.example.mvc.repository;

import com.example.mvc.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
