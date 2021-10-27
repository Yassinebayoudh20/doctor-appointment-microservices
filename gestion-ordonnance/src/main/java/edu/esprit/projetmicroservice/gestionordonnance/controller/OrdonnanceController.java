package edu.esprit.projetmicroservice.gestionordonnance.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.esprit.projetmicroservice.gestionordonnance.model.Ordonnance;
import edu.esprit.projetmicroservice.gestionordonnance.service.OrdonnanceService;
@RestController
@CrossOrigin(origins = "http://localhost:8086")
@RequestMapping("/api/ordonnances")
public class OrdonnanceController {
	@Autowired
	private final OrdonnanceService ordonnanceService;

    public OrdonnanceController(final OrdonnanceService ordonnanceService) {
        this.ordonnanceService = ordonnanceService;
    }
    @GetMapping("/")
    public List<Ordonnance> getOrdonnances(){
        
            List<Ordonnance> ordonnaces = ordonnanceService.findAll();
           
     
            return ordonnaces;
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordonnance> getOrdonnance(@PathVariable final Long id) {
        return ResponseEntity.ok(ordonnanceService.get(id));
    }
/*{
    "nomMedcin":"firstEvent",
    "prenomMedcin" : "This is a event Description 2",
    "dateOrdonnance" : "2020-08-08",
    "nomPatient" :"https://picsum.photos/200",
    "prenomPatient" :"https://picsum.photos/200",
    "localeCabinet" : "hahahah"
    
}*/
    @PostMapping
    @ResponseBody
    public ResponseEntity<Long> createOrdonnance(
            @RequestBody final Ordonnance ordonnanceDTO) {
        return new ResponseEntity<>(ordonnanceService.create(ordonnanceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> updateOrdonnance(@PathVariable final Long id,
            @RequestBody  final Ordonnance ordonnanceDTO) {
        ordonnanceService.update(id, ordonnanceDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdonnance(@PathVariable final Long id) {
        ordonnanceService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
