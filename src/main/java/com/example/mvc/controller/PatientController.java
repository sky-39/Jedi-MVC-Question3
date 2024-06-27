package com.example.mvc.controller;

import com.example.mvc.model.Patient;
import com.example.mvc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient/{id}")
    public ResponseEntity<?> getPatient(@PathVariable int id){
        Optional<Patient> patient = patientService.getPatientById(id);
        if(patient.isPresent()){
            return ResponseEntity.ok(patient.get());
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "Patient Not Found");
            return ResponseEntity.status(404).body(modelAndView);
        }
    }

    @PostMapping("/patient")
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient){
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(savedPatient.getId());
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable int id){
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}
