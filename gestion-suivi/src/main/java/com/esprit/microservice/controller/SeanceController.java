package com.esprit.microservice.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.client.RestTemplate;

import com.esprit.microservice.model.Ordonnance;
import com.esprit.microservice.model.Seance;
import com.esprit.microservice.service.SeanceService;


@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping(value = "/api/seances")
public class SeanceController {
	@Autowired
	private final SeanceService seanceService;
	@Autowired
	private RestTemplate restTemplate;
	private String BASE_Url = "http://localhost:8086/api/ordonnances";
	
    public SeanceController(final SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Seance>> getAllMedicaments() {
        return ResponseEntity.ok(seanceService.findAll());
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Seance> getbyId(@PathVariable Long id) {
        return ResponseEntity.ok(seanceService.get(id));
    }

    @GetMapping("getseanceWithOrdonnance/{id}/{idOrdonnace}")
    public ResponseEntity<Map<String, Object>> getseanceWithOrdonnance(@PathVariable final Long id) {
        
        String uri = BASE_Url+"/"+id;
    	Ordonnance ordonnace =restTemplate.getForObject(uri, Ordonnance.class);
    	Seance sea = seanceService.get(id);
    	Map<String, Object> test = new HashMap<>();
    	test.put("ordonnace", ordonnace);
    	test.put("seance", sea);
    	
    	
    	return ResponseEntity.ok(test);
    
        
        
    }
  /*  @GetMapping("getseanceWithOrdonnance/{id}/{idOrdonnace}")
    public ResponseEntity<Map<String, Object>> getseanceWithReclamation(@PathVariable final Long id) {
        
        String uri = BASE_Url+"/"+id;
    	Ordonnance ordonnace =restTemplate.getForObject(uri, Ordonnance.class);
    	HttpEntity entity1 = new HttpEntity<>(lead, new HttpHeaders());
    	ResponseEntity<String> htmlResponse = restTemplate.exchange(requestUrl, HttpMethod.POST, entity1, String.class);
    	
    	Seance sea = seanceService.get(id);
    	Map<String, Object> test = new HashMap<>();
    	test.put("ordonnace", ordonnace);
    	test.put("seance", sea);
    	
    	
    	return ResponseEntity.ok(test);}
 
    	  @RequestMapping(value = "getseanceWithOrdonnance/{id}")
    	    public Seance getseanceWithOrdonnance(@PathVariable("id") int id) {
    		  Seance sea = seanceService.get((long) id);
    	      HttpHeaders httpHeaders = new HttpHeaders();
    	        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    	        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
    	        return restTemplate.exchange("http://localhost:8087/api/Reclamation", HttpMethod.GET, entity, Post[].class).getBody();
    	    }
        
         */  
    
    @PutMapping("/addOrdonnaceToSeance/{idOrdonnace}/{idSe}")
    public int addOrdonnaceToSeance (@PathVariable("idOrdonnace")Long id,@PathVariable("idSe") int ideUp )
    {
    	
    	
    	seanceService.addOrdonnaceToSeance(ideUp, id);
    	return 1;
    	
        }
    /*{
    "typeAvancement":"good",
    "remarques" : "This is a Description 2",
    "dateSeance" : "2020-08-08"
    
}*/
    @PostMapping
    public ResponseEntity<Long> createMedicament(
            @RequestBody final Seance medicamentDTO) {
        return new ResponseEntity<>(seanceService.create(medicamentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMedicament(@PathVariable final Long id,
            @RequestBody final Seance medicamentDTO) {
    	seanceService.update(id, medicamentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicament(@PathVariable final Long id) {
    	seanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/affecterSeanceaSuivi/{idS}/{idSu}")
	 @ResponseBody
	 public int affecterMedicamentaOrdonnance(@PathVariable("idS") int idS ,@PathVariable("idSu") int idSu) {
    	seanceService.affecterMedicamentaOrdonnance(idS, idSu);
    	return 1;
	 }

}
