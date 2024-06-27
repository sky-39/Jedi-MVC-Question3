package com.example.mvc.controller;

import com.example.mvc.model.Doctor;
import com.example.mvc.service.DoctorService;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class DoctorController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/doctor/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable int id){
        DoctorService doctorService = applicationContext.getBean(DoctorService.class);
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        if(doctor.isPresent()){
            return ResponseEntity.ok(doctor.get());
        } else {
            ModelAndView modelAndView =  new ModelAndView("error");
            modelAndView.addObject("message", "Doctor Not Found");
            return ResponseEntity.status(404).body(modelAndView);
        }
    }

    @PostMapping("/doctor")
    public ResponseEntity<Integer> addDoctor(@RequestBody Doctor doctor){
        DoctorService doctorService = applicationContext.getBean(DoctorService.class);
        Doctor savedDoctor = doctorService.addDoctor(doctor);
        return ResponseEntity.ok(savedDoctor.getId());
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable int id){
        DoctorService doctorService = applicationContext.getBean(DoctorService.class);
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok().build();
    }
}
