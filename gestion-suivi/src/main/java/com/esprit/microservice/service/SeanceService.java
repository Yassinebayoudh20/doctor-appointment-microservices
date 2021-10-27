package com.esprit.microservice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.microservice.model.Seance;
import com.esprit.microservice.model.Suivi;
import com.esprit.microservice.repository.SeanceRepository;
import com.esprit.microservice.repository.SuiviRepository;


@Service
public class SeanceService {
	 private final SeanceRepository seanceRepository;
	 
	    private final SuiviRepository suiviRepository;

	    public SeanceService(final SeanceRepository seanceRepository,
	            final SuiviRepository suiviRepository) {
	        this.seanceRepository = seanceRepository;
	        this.suiviRepository = suiviRepository;
	    }
	    @Transactional
	    public List<Seance> findAll() {
	      
	    	List<Seance> medicament	=seanceRepository.findAll()
	             ;
	        		  return medicament;
	    }

	    public Seance get(final Long id) {
	        return seanceRepository.findById(id).get()
	                ;
	    }
 
	    public Long create(final Seance seance) {
	    
	        return seanceRepository.save(seance).getId();
	    }

	    public void update(final Long id,final Seance seance) {
	        final Seance seancee = seanceRepository.findById(id).get();
	        seanceRepository.save(seancee);
	    }

	    public void delete(final Long id) {
	    	seanceRepository.deleteById(id);
	    }
	
		public void affecterMedicamentaOrdonnance(int medicId, int id) {
			Seance mid = seanceRepository.findById((long) medicId).get() ;
		Suivi ord = suiviRepository.findById((long) id).get() ;
		if (ord.getSeances()==null)
		{
			Set<Seance> seances = new HashSet<Seance>() ;
			seances.add(mid);
			mid.setSuivis(ord);
		}
		else 
			{mid.setSuivis(ord);}
		
		seanceRepository.save(mid);
		
		
		
		
		}
		public void addOrdonnaceToSeance(int idS, Long idO) {
			Seance mid = seanceRepository.findById((long) idS).get() ;
	       mid.setIdOrdonnance(idO);

	seanceRepository.save(mid);
		
		
		
		}

}
