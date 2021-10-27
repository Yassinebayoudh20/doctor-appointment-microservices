package edu.esprit.projetmicroservice.gestionordonnance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import edu.esprit.projetmicroservice.gestionordonnance.model.Medicament;
import edu.esprit.projetmicroservice.gestionordonnance.service.MedicamentService;


@CrossOrigin(origins = "http://localhost:8086")
@RestController
@RequestMapping(value = "/api/medicaments")
public class MedicamentController {

    @Autowired
	private final MedicamentService medicamentService;

    public MedicamentController(final MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Medicament>> getAllMedicaments() {
        return ResponseEntity.ok(medicamentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicament> getMedicament(@PathVariable final Long id) {
        return ResponseEntity.ok(medicamentService.get(id));
    }
/*{
    "nomMedicament":"adol",
    "dosageMedicament" : "chwaia",
     "idOrdonnance" :"2"
    
}*/
    @PostMapping
    public ResponseEntity<Long> createMedicament(
            @RequestBody final Medicament medicamentDTO) {
        return new ResponseEntity<>(medicamentService.create(medicamentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMedicament(@PathVariable final Long id,
            @RequestBody final Medicament medicamentDTO) {
        medicamentService.update(id, medicamentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicament(@PathVariable final Long id) {
        medicamentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/affecterMedicamentaOrdonnance/{idM}/{idO}")
	 @ResponseBody
	 public int affecterMedicamentaOrdonnance(@PathVariable("idM") int idM ,@PathVariable("idO") int idO) {
    	medicamentService.affecterMedicamentaOrdonnance(idM,idO);
	 return 1 ;
	 }
}
