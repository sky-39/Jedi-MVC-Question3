package com.example.mvc.service;

import com.example.mvc.model.Doctor;
import com.example.mvc.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public Optional<Doctor> getDoctorById(int id){
        return doctorRepository.findById(id);
    }

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(int id){
        doctorRepository.deleteById(id);
    }
}
