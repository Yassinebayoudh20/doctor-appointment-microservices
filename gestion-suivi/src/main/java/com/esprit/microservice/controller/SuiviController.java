package com.esprit.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.model.Suivi;
import com.esprit.microservice.service.SuiviService;

@RestController
@CrossOrigin(origins = "http://localhost:8088")
@RequestMapping("/api/suivis")
public class SuiviController {
	@Autowired
	private final SuiviService suiviService;

    public SuiviController(final SuiviService suiviService) {
        this.suiviService = suiviService;
    }
    @GetMapping("/")
    public List<Suivi> getOrdonnances(){
        
            List<Suivi> ordonnaces = suiviService.findAll();
           
     
            return ordonnaces;
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suivi> getOrdonnance(@PathVariable final Long id) {
        return ResponseEntity.ok(suiviService.get(id));
    }

    /*{
    "nomMedcin":"good",
    "nomPatient" : "ahmed",
    "dateDebut" : "2020-08-08",
    "dateFin" : "2020-08-08",
    "nbrSeances":3
    
}*/
    @PostMapping
    @ResponseBody
    public ResponseEntity<Long> createOrdonnance(
            @RequestBody final Suivi ordonnanceDTO) {
        return new ResponseEntity<>(suiviService.create(ordonnanceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> updateOrdonnance(@PathVariable final Long id,
            @RequestBody  final Suivi ordonnanceDTO) {
    	suiviService.update(id, ordonnanceDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdonnance(@PathVariable final Long id) {
    	suiviService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
