package com.example.mvc.repository;

import com.example.mvc.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
