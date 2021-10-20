package edu.esprit.projetmicroservice.gestionmedecin.controller;

import edu.esprit.projetmicroservice.gestionmedecin.dto.DoctorDTO;
import edu.esprit.projetmicroservice.gestionmedecin.model.Doctor;
import edu.esprit.projetmicroservice.gestionmedecin.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@Slf4j
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //GET URL  =  http://localhost:9001/api/v1/doctors/
    @GetMapping(value = "/")
    public ResponseEntity<List<Doctor>> getDoctors(){
        try {
            List<Doctor> doctors = doctorService.findAllDoctors();
            if(doctors == null || doctors.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            log.debug("Doctors list has been retrieved from database result = {}",doctors);
            return ResponseEntity.ok().body(doctors);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    //POST URL  =  http://localhost:9001/api/v1/doctors/
    /* {
        "name": "Yassine",
        "password": "azerty12",
        "phoneNumber": "28114329",
        "birthday": "1997-09-15",
        "lastName": "Bayoudh",
        "specialty":"Sergent",
        "sex": "Male",
        "email": "yassine@gmail.com"
        } */
    @PostMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Long> addDoctor(@RequestBody Doctor doctor){
        try {
              long doctorID = doctorService.addNewDoctor(doctor);
              if(doctorID == 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
              log.info("Object {} has been created",doctor);
              return ResponseEntity.status(HttpStatus.CREATED).body(doctorID);
        }catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    //GET/{id} URL = http://localhost:9001/api/v1/doctors/1
    @GetMapping(value="/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable long id){
        try {
            if(id == 0 ) return ResponseEntity.badRequest().build();
            Doctor doctor = doctorService.findDoctorById(id);
            if(doctor == null) return ResponseEntity.notFound().build();
            log.info("Object {} found",doctor);
            return ResponseEntity.status(HttpStatus.OK).body(doctor);
        }catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    //PUT URL = http://localhost:9001/api/v1/doctors/
        /* {
        "id":"1"
        "name": "Yassine",
        "password": "azerty12",
        "phoneNumber": "28114329",
        "birthday": "1997-09-15",
        "lastName": "Bayoudh",
        "specialty":"Sergent",
        "sex": "Male",
        "email": "yassine@gmail.com"
        } */
    @PutMapping(value="/")
    @ResponseBody
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){
        try {
            Doctor doctorToUpdate = doctorService.updateDoctor(doctor);
            if(doctorToUpdate == null) return ResponseEntity.badRequest().build();
            log.info("Object {} modified to {}",doctor,doctorToUpdate);
            return ResponseEntity.ok(doctorToUpdate);
        }catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    //DELETE URL = http://localhost:9001/api/v1/doctors/1
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteDoctorById(@PathVariable long id){
        try{
            if(id == 0) return ResponseEntity.badRequest().build();
            long doctorToDeleteID = doctorService.deleteDoctorById(id);
            if(doctorToDeleteID == 0) return ResponseEntity.notFound().build();
            log.info("Doctor with id={} was deleted",doctorToDeleteID);
            return ResponseEntity.ok(doctorToDeleteID);
        }catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();

        }
    }
}
